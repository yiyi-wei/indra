package com.indra.cloud.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.indra.cloud.api.auth.constant.SysTypeEnum;
import com.indra.cloud.api.auth.dto.AuthAccountDTO;
import com.indra.cloud.api.auth.feign.AccountFeignClient;
import com.indra.cloud.api.auth.vo.AuthAccountVO;
import com.indra.cloud.api.leaf.feign.SegmentFeignClient;
import com.indra.cloud.api.user.vo.UserApiVO;
import com.indra.cloud.common.cache.constant.UserCacheNames;
import com.indra.cloud.common.database.dto.PageDTO;
import com.indra.cloud.common.database.util.PageUtil;
import com.indra.cloud.common.database.vo.PageVO;
import com.indra.cloud.common.exception.IndraCloudException;
import com.indra.cloud.common.response.ResponseEnum;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.common.utils.BooleanUtil;
import com.indra.cloud.common.utils.IpHelper;
import com.indra.cloud.rabbitmq.constant.ExchangeMQName;
import com.indra.cloud.rabbitmq.constant.RoutingKeyMQName;
import com.indra.cloud.user.dto.UserRegisterDTO;
import com.indra.cloud.user.mapper.UserMapper;
import com.indra.cloud.user.model.User;
import com.indra.cloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户表
 *
 * @author YXF
 * @date 2020-12-08 11:18:04
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private SegmentFeignClient segmentFeignClient;
    @Autowired
    private AmqpTemplate amqpTemplate;


    @Override
    public PageVO<UserApiVO> page(PageDTO pageDTO) {
        return PageUtil.doPage(pageDTO, () -> userMapper.list());
    }

    @Override
    @Cacheable(cacheNames = UserCacheNames.USER_INFO, key = "#userId")
    public UserApiVO getByUserId(Long userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    @CacheEvict(cacheNames = UserCacheNames.USER_INFO, key = "#user.userId")
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<UserApiVO> getUserByUserIds(List<Long> userIds) {
        if (CollUtil.isEmpty(userIds)) {
            return new ArrayList<>();
        }
        return userMapper.getUserByUserIds(userIds);
    }

    @Override
    public UserApiVO getUserAndOpenIdsByUserId(Long userId) {
        return userMapper.getUserAndOpenIdsByUserId(userId);
    }

    @Override
    // TODO 分布式事务 @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ServerResponseEntity<Long> save(UserRegisterDTO param) {
        // 检查用户名是否存在
        this.checkRegisterInfo(param);

        // leaf相关，获取分布式id -> userId
        ServerResponseEntity<Long> segmentIdResponse = segmentFeignClient.getSegmentId(User.DISTRIBUTED_ID_KEY);
        if (!segmentIdResponse.isSuccess()) {
            throw new IndraCloudException(ResponseEnum.EXCEPTION);
        }
        Long userId = segmentIdResponse.getData();

        param.setUserId(userId);

        AuthAccountDTO authAccountDTO = new AuthAccountDTO();
        authAccountDTO.setCreateIp(IpHelper.getIpAddr());
        authAccountDTO.setPassword(param.getPassword());
        authAccountDTO.setIsAdmin(0);
        authAccountDTO.setSysType(SysTypeEnum.ORDINARY.value());
        authAccountDTO.setUsername(param.getUserName());
        authAccountDTO.setStatus(1);
        authAccountDTO.setUserId(userId);

        // 保存统一账户信息，这里没问题的，以为发出去了如果auth服务报错了会回滚，user服务后面的代码也不会执行了
        ServerResponseEntity<Long> serverResponse = accountFeignClient.save(authAccountDTO);

        // 抛异常回滚
        if (!serverResponse.isSuccess()) {
            throw new IndraCloudException(serverResponse.getMsg());
        }

        User user = new User();
        user.setUserId(userId);
        user.setPic(param.getImg());
        user.setNickName(param.getNickName());
        user.setStatus(1);
        // 上面存进了auth的库，在这里是保存进user服务自己的库
        Integer isSaved = userMapper.save(user);

        Long uid = serverResponse.getData();
        // 如果这一步出错了即：新增的条目数不是1
        if(BooleanUtil.isFalse(isSaved)) {
            // 要通知auth服务回滚刚刚写入的操作，这部分利用MQ实现
            log.info("分布式事务 --- user 表新增失败");
            amqpTemplate.convertAndSend(ExchangeMQName.USER_ROLLBACK_EXCHANGE, RoutingKeyMQName.USER_ROLLBACK_ROUTING_KEY, uid);
            return ServerResponseEntity.fail(ResponseEnum.EXCEPTION);
        }

        return ServerResponseEntity.success(uid);
    }

    /**
     * 查询一下用户名是否存在
     * @param userRegisterDTO
     */
    private void checkRegisterInfo(UserRegisterDTO userRegisterDTO) {
        ServerResponseEntity<AuthAccountVO> responseEntity = accountFeignClient.getByUsernameAndSysType(userRegisterDTO.getUserName(), SysTypeEnum.ORDINARY);
        if (!responseEntity.isSuccess()) {
            throw new IndraCloudException(responseEntity.getMsg());
        }
        if (Objects.nonNull(responseEntity.getData())) {
            throw new IndraCloudException("用户名已存在");
        }
    }

}

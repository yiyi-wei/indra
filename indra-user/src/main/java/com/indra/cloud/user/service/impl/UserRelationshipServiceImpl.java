package com.indra.cloud.user.service.impl;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.api.user.vo.UserApiVO;
import com.indra.cloud.common.cache.constant.CacheNames;
import com.indra.cloud.common.cache.util.CacheManagerUtil;
import com.indra.cloud.common.response.ResponseEnum;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.common.utils.BooleanUtil;
import com.indra.cloud.user.mapper.FansMapper;
import com.indra.cloud.user.model.Fans;
import com.indra.cloud.user.service.UserRelationshipService;
import com.indra.cloud.user.service.UserService;
import com.indra.cloud.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/21 11:03
 * @description: TODO
 */
@Service
@Slf4j
public class UserRelationshipServiceImpl implements UserRelationshipService {

    @Autowired
    private FansMapper fansMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MapperFacade mapperFacade;
    @Autowired
    private CacheManagerUtil cacheManagerUtil;

    @Override
    public ServerResponseEntity<UserVO> getFansListByUserId(Integer isAdmin, Long userId) {
        UserVO userVO = new UserVO();

        // 管理员没有粉丝直接返回。
        if(BooleanUtil.isTrue(isAdmin)) {
            return ServerResponseEntity.success(userVO);
        }

        ServerResponseEntity<UserVO> follower = getFollowerByUserId(userId);

        if(ObjectUtils.isEmpty(follower.getData())) {
            return ServerResponseEntity.showFailMsg("关注用户不存在");
        }

        userVO = selectFansByUserId(userId);

        return ServerResponseEntity.success(userVO);
    }

    @Override
    public ServerResponseEntity<UserVO> getFollowersListByUserId(UserInfoInTokenBO userInfoInTokenBO) {
        UserVO userVOS = new UserVO();
        // 管理员没有关注的人直接返回。
        if(BooleanUtil.isTrue(userInfoInTokenBO.getIsAdmin())) {
            return ServerResponseEntity.success(userVOS);
        }

        userVOS = selectFollowersByUserId(userInfoInTokenBO.getUserId());

        return ServerResponseEntity.success(userVOS);
    }

    @Override
    public ServerResponseEntity<Integer> followByUserId(Long fansId, Long followerId) {
        if(followerId.equals(fansId)) {
            return ServerResponseEntity.showFailMsg("不能关注自己哦!");
        }
        Fans fans = new Fans();
        fans.setUserId(followerId);
        fans.setFansId(fansId);
        fans.setStatus(1);
        Integer saved = fansMapper.save(fans);
        // 删除缓存重新获取
        cacheManagerUtil.evictCache(CacheNames.FANS_LIST_KEY, String.valueOf(followerId));

        selectFansByUserId(followerId);

        if(BooleanUtil.isTrue(saved)) {
            return ServerResponseEntity.success();
        }

        return ServerResponseEntity.fail(ResponseEnum.EXCEPTION);
    }

    @Override
    public ServerResponseEntity<UserVO> getFollowerByUserId(Long userId) {
        UserApiVO userApiVO = userService.getByUserId(userId);
        UserVO userVO = mapperFacade.map(userApiVO, UserVO.class);
        if(ObjectUtils.isEmpty(userVO)) {
            return ServerResponseEntity.fail(ResponseEnum
                    .OK, userVO);

        }
        return ServerResponseEntity.success(userVO);
    }

    /**
     * 将关注的人放入缓存
     * @param userId userid
     * @return 关注列表
     */
    private UserVO selectFollowersByUserId(Long userId) {
        return null;
    }


    /**
     * 将粉丝放入缓存
     * @param userId userid
     * @return 粉丝列表
     */
    // @Cacheable(cacheNames = CacheNames.FANS_LIST_KEY, key = "#userId")
    public UserVO selectFansByUserId(Long userId) {
        UserVO userVO = cacheManagerUtil.getCache(CacheNames.FANS_LIST_KEY, String.valueOf(userId));
        if(ObjectUtils.isEmpty(userVO)) {
            userVO = fansMapper.selectFansByUserId(userId);
            cacheManagerUtil.putCache(CacheNames.FANS_LIST_KEY, String.valueOf(userId), userVO);
            return userVO;
        }
        return userVO;
    }
}

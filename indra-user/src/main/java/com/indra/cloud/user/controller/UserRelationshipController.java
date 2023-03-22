package com.indra.cloud.user.controller;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.common.response.ResponseEnum;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.common.security.AuthUserContext;
import com.indra.cloud.user.service.UserRelationshipService;
import com.indra.cloud.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 *
 * @Author: 魏一yi
 * @Date: 2023/3/21 10:08
 * @description: 用户好友关系控制器
 */

@RestController
@RequestMapping("/relation")
@Slf4j
public class UserRelationshipController {

    @Autowired
    private UserRelationshipService userRelationshipService;

    @GetMapping("/fans")
    public ServerResponseEntity<UserVO> getFansByUserId() {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        ServerResponseEntity<UserVO> userVOSRes =
                userRelationshipService.getFansListByUserId(userInfoInTokenBO.getIsAdmin(), userInfoInTokenBO.getUserId());

        return ServerResponseEntity.success(userVOSRes.getData());
    }

    @GetMapping("/followers")
    public ServerResponseEntity<UserVO> getFollowersByUserId() {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        ServerResponseEntity<UserVO> userVOSRes = userRelationshipService.getFollowersListByUserId(userInfoInTokenBO);

        return ServerResponseEntity.success(userVOSRes.getData());
    }

    /**
     * 关注
     * @return
     */
    @PostMapping
    public ServerResponseEntity<Void> followByUserId(Long userId) {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        ServerResponseEntity<UserVO> fansRes = userRelationshipService.getFansListByUserId(0, userId);

        if(!fansRes.isSuccess()) {
            log.info("userId: {}, 关注不存在的用户，恶意攻击接口", userInfoInTokenBO.getUserId());
            return ServerResponseEntity.fail(ResponseEnum.MALICIOUS_ATTACKS);
        }

        if(!ObjectUtils.isEmpty(fansRes.getData())) {
            // 判断是否关注处在关注状态，如果是，则可能是恶意攻击接口
            for(int i = 0; i < fansRes.getData().getFansList().size(); i++) {
                UserVO fans = fansRes.getData().getFansList().get(i);
                if(Objects.equals(fans.getUserId(), userInfoInTokenBO.getUserId())) {
                    log.info("userId: {}, 多次关注同一个用户，恶意攻击接口", userInfoInTokenBO.getUserId());
                    return ServerResponseEntity.fail(ResponseEnum.MALICIOUS_ATTACKS);
                }
            }
        }
        ServerResponseEntity<Integer> responseEntity = userRelationshipService.followByUserId(userInfoInTokenBO.getUserId(), userId);

        if(!responseEntity.isSuccess()) {
            return ServerResponseEntity.showFailMsg(responseEntity.getMsg());
        }

        return ServerResponseEntity.success();
    }
}

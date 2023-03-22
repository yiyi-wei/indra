package com.indra.cloud.user.service;

import com.indra.cloud.api.auth.bo.UserInfoInTokenBO;
import com.indra.cloud.common.response.ServerResponseEntity;
import com.indra.cloud.user.vo.UserVO;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/21 11:02
 * @description: TODO
 */
public interface UserRelationshipService {

    /**
     * 根据用户id获取UserVO对象，内部的FansList是该用户的粉丝列表
     * @param isAdmin 是否是管理员
     * @param userId 此用户id下的粉丝
     * @return 粉丝列表
     */
    ServerResponseEntity<UserVO> getFansListByUserId(Integer isAdmin, Long userId);

    /**
     * 根据用户id获取关注的用户
     * @param userInfoInTokenBO 缓存中的用户信息
     * @return 关注列表
     */
    ServerResponseEntity<UserVO> getFollowersListByUserId(UserInfoInTokenBO userInfoInTokenBO);


    /**
     * 根据大V的userId进行关注
     * @param fansId 自己的userid
     * @param followerId 大V的userid
     * @return
     */
    ServerResponseEntity<Integer> followByUserId(Long fansId, Long followerId);

    /**
     * 根据userid获取用户
     * @param userId
     * @return
     */
    ServerResponseEntity<UserVO> getFollowerByUserId(Long userId);
}

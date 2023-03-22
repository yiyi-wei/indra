package com.indra.cloud.api.auth.bo;


import com.indra.cloud.api.auth.constant.SysTypeEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 保存在token信息里面的用户信息
 *
 * com.indra.cloud.auth.service.impl.AuthAccountServiceImpl
 * com.indra.cloud.auth.controller.LoginController
 * @author FrozenWatermelon
 * @date 2020/7/3
 */
@Data
@Component
public class UserInfoInTokenBO {

	/**
	 * 用户在自己系统的用户id
	 */
	private Long userId;

	/**
	 * 全局唯一的id,
	 */
	private Long uid;

	/**
	 * 租户id (商家id)
	 */
	private Long tenantId;

	/**
	 * 系统类型
	 * @see SysTypeEnum
	 */
	private Integer sysType;

	/**
	 * 是否是管理员
	 */
	private Integer isAdmin;

	private String bizUserId;

	private String bizUid;

}

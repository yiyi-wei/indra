package com.indra.cloud.api.rbac.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author FrozenWatermelon
 * @date 2020/9/2
 */
@Data
public class CheckPermissionDTO {

	/**
	 * 用户id
	 */
	@NotNull(message = "userId not null")
	private Long userId;

	/**
	 * 系统类型
	 */
	@NotNull(message = "sysType not null")
	private Integer sysType;

	/**
	 * uri
	 */
	@NotBlank(message = "uri not blank")
	private String uri;

	/**
	 * 是否是管理员
	 */
	@NotNull(message = "isAdmin not null")
	private Integer isAdmin;

	/**
	 * 请求方法 1.GET 2.POST 3.PUT 4.DELETE
	 */
	private Integer method;


}

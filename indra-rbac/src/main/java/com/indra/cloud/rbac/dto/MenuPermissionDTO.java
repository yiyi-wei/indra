package com.indra.cloud.rbac.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 菜单资源DTO
 *
 * @author FrozenWatermelon
 * @date 2020-09-15 16:35:01
 */
@Data
public class MenuPermissionDTO {
    private static final long serialVersionUID = 1L;

    /**菜单资源用户id*/
    private Long menuPermissionId;

    @NotNull(message = "menuId NotNull")
    /**资源关联菜单*/
    private Long menuId;

	@NotBlank(message = "permission NotBlank")
    /**权限对应的编码*/
    private String permission;

    /**资源名称*/
    private String name;

    /**资源对应服务器路径*/
	@NotBlank(message = "uri NotBlank")
    private String uri;

	@NotNull(message = "method NotNull")
    /**请求方法 1.GET 2.POST 3.PUT 4.DELETE*/
    private Integer method;

}

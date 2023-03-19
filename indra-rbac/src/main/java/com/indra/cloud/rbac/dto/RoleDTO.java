package com.indra.cloud.rbac.dto;

import lombok.Data;

import java.util.List;

/**
 * 角色DTO
 *
 * @author FrozenWatermelon
 * @date 2020-09-17 19:15:44
 */
@Data
public class RoleDTO{
    private static final long serialVersionUID = 1L;

    /**角色id*/
    private Long roleId;

    /**角色名称*/
    private String roleName;

    /**备注*/
    private String remark;

	/**菜单id列表*/
	private List<Long> menuIds;

	/**菜单资源id列表*/
	private List<Long> menuPermissionIds;


}

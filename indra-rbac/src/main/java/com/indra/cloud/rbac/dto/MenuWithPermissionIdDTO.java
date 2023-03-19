package com.indra.cloud.rbac.dto;

import lombok.Data;

import java.util.List;

/**
 * 菜单id和权限id列表
 * @author FrozenWatermelon
 * @date 2020/9/18
 */
@Data
public class MenuWithPermissionIdDTO {

    /**菜单id*/
    private Long menuId;

    /**菜单下的权限id列表*/
    private List<Long> permissionIds;


}

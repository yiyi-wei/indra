package com.indra.cloud.api.rbac.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author FrozenWatermelon
 * @date 2020/11/27
 */
@Data
public class ClearUserPermissionsCacheDTO {

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

}

package com.indra.cloud.user.model;

import com.indra.cloud.common.model.BaseModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 省市区地区信息
 * @TableName area
 */
@Data
@Component
public class Area extends BaseModel implements Serializable {
    /**
     * 
     */
    private Long areaId;


    /**
     * 地址
     */
    private String areaName;

    /**
     * 上级地址
     */
    private Long parentId;

    /**
     * 等级（从1开始）
     */
    private Integer level;

    private static final long serialVersionUID = 1L;
}
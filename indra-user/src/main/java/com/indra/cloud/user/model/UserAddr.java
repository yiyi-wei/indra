package com.indra.cloud.user.model;

import com.indra.cloud.common.model.BaseModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户地址
 * @TableName user_addr
 */
@Data
@Component
public class UserAddr extends BaseModel implements Serializable {
    /**
     * ID
     */
    private Long addrId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 是否默认地址 1是
     */
    private Integer isDefault;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 省ID
     */
    private Long provinceId;

    /**
     * 省
     */
    private String province;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 城市
     */
    private String city;

    /**
     * 区ID
     */
    private Long areaId;

    /**
     * 区
     */
    private String area;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 地址
     */
    private String addr;

    /**
     * 经度
     */
    private BigDecimal lng;

    /**
     * 纬度
     */
    private BigDecimal lat;

    private static final long serialVersionUID = 1L;
}
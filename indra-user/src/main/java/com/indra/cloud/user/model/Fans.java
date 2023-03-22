package com.indra.cloud.user.model;

import com.indra.cloud.common.model.BaseModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 粉丝表
 * @TableName fans
 */
@Data
@Component
public class Fans extends BaseModel implements Serializable {
    /**
     * ID
     */
    private Long userId;

    /**
     * 粉丝Id
     */
    private Long fansId;

    /**
     * 1 正常关注 0 取消关注
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}
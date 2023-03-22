package com.indra.cloud.user.model;

import com.indra.cloud.common.model.BaseModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 用户表
 * @TableName user
 */
@Data
@Component
public class User extends BaseModel implements Serializable {
    /**
     * ID
     */
    private Long userId;


    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像图片路径
     */
    private String pic;

    /**
     * 状态 1 正常 0 无效
     */
    private Integer status;

    /**
     * 参照b站的等级系统，默认是-1没有转正，其余有1-6六个等级
     */
    private Integer level;

    /**
     * 粉丝数
     */
    private Integer fans;

    /**
     * 经验值，用于提升level
     */
    private Integer exp;

    private static final long serialVersionUID = 1L;
    public static final String DISTRIBUTED_ID_KEY = "indra-user";

}
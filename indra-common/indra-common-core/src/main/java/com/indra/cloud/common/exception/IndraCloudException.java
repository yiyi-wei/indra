package com.indra.cloud.common.exception;

import com.indra.cloud.common.response.ResponseEnum;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/15 16:53
 * @description: TODO
 */
public class IndraCloudException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Object object;

    private ResponseEnum responseEnum;
    
    public IndraCloudException(String msg) {super(msg);}

    public IndraCloudException(String msg, Object object) {
        super(msg);
        this.object = object;
    }

    public IndraCloudException(String msg, Throwable cause) {
        super(msg, cause);
    }


    public IndraCloudException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
    }

    public IndraCloudException(ResponseEnum responseEnum, Object object) {
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
        this.object = object;
    }


    public Object getObject() {
        return object;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}

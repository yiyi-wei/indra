package com.indra.cloud.user.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/19 20:59
 * @description: TODO
 */
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
@Target({ElementType.METHOD}) // 加在方法上
public @interface RequiredToken {
}

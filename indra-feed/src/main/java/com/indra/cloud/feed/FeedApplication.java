package com.indra.cloud.feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * 用户拉，是对外 api
 * 我们推，是对内 api（推的条件是这个用户关注的用户有更新的内容）
 *
 * @Author: 魏一yi
 * @Date: 2023/3/20 9:06
 * @description: TODO
 */
@SpringBootApplication(scanBasePackages = { "com.indra.cloud" })
@EnableFeignClients(basePackages = {"com.indra.cloud.api.**.feign"})
public class FeedApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeedApplication.class, args);
    }

}

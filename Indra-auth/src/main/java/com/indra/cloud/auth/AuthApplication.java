package com.indra.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = { "com.indra.cloud" })
@EnableFeignClients(basePackages = {"com.indra.cloud.api.**.feign"})
public class AuthApplication {
    public static void main( String[] args ) {
        SpringApplication.run(AuthApplication.class, args);
    }
}

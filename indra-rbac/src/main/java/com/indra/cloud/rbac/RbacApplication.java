package com.indra.cloud.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author FrozenWatermelon
 * @date 2020/6/24
 */
@SpringBootApplication(scanBasePackages = { "com.indra.cloud" })
@EnableFeignClients(basePackages = {"com.indra.cloud.api.**.feign"})
public class RbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacApplication.class, args);
	}

}

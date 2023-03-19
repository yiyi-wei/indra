package com.indra.cloud.api.leaf.feign;

import com.indra.cloud.common.feign.FeignInsideAuthConfig;
import com.indra.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 魏一yi
 * @Date: 2023/3/16 19:13
 * @description: TODO
 */
@FeignClient(value = "indra-leaf",contextId ="segment")
public interface SegmentFeignClient {

    /**
     * 获取id
     * @param key
     * @return
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/segment")
    ServerResponseEntity<Long> getSegmentId(@RequestParam("key") String key);


}

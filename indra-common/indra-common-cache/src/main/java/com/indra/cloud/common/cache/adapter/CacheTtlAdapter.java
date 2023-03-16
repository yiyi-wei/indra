package com.indra.cloud.common.cache.adapter;

import com.indra.cloud.common.cache.bo.CacheNameWithTtlBO;

import java.util.List;

/**
 * 实现该接口之后，根据缓存的cacheName和ttl将缓存进行过期
 *
 * @Author: 魏一yi
 * @Date: 2023/3/15 17:47
 * @description: TODO
 */
public interface CacheTtlAdapter {
    /**
     * 根据缓存的cacheName和ttl将缓存进行过期
     * @return 需要独立设置过期时间的缓存列表
     */
    List<CacheNameWithTtlBO> listCacheNameWithTtl();
}

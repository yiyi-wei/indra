package com.indra.cloud.common.cache.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @author FrozenWatermelon
 * @date 2020/09/03
 */
@Component
public class CacheManagerUtil {

	private final CacheManager cacheManager;

	@Autowired
	public CacheManagerUtil(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	/**
	 * 获取缓存
	 * @param cacheName 缓存名
	 * @param key key
	 * @return 缓存value
	 * @param <T> 泛型
	 */
	@SuppressWarnings({ "unchecked" })
	public <T> T getCache(String cacheName, String key) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			return null;
		}
		Cache.ValueWrapper valueWrapper = cache.get(key);
		if (valueWrapper == null) {
			return null;
		}
		return (T) valueWrapper.get();
	}

	/**
	 * 更改缓存value
	 * @param cacheName 缓存名
	 * @param key key
	 * @param value value
	 */

	public void putCache(String cacheName, String key, Object value) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			cache.put(key, value);
		}
	}

	/**
	 * 删除缓存
	 * @param cacheName 缓存名
	 * @param key key
	 */
	public void evictCache(String cacheName, String key) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			cache.evict(key);
		}
	}

}

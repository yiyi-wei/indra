package com.indra.cloud.common.cache.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 通过 cacheName 配置 和 时间告诉缓存多久清除一遍
 *
 * @author FrozenWatermelon
 * @date 2020/7/4
 */
@ToString
@Data
@AllArgsConstructor
public class CacheNameWithTtlBO {

	private String cacheName;

	private Integer ttl;

}

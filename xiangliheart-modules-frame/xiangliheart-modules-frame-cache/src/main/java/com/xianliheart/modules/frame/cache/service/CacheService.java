/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xianliheart.modules.frame.cache.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * CacheService
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/9/15
 */
@Slf4j
@Component
public class CacheService {
    private final int EXPIRE_TIME = 1;
    private final TimeUnit EXPIRE_TIME_TYPE = TimeUnit.DAYS;
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Value("${redis.default-key-prefix}")
    private String DEFAULT_KEY_PREFIX;

    /**
     * add 数据缓存至redis
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, V> void add(K key, V value) {
        try {
            if (value != null) {
                redisTemplate.opsForValue().set(DEFAULT_KEY_PREFIX + key, objectMapper.writeValueAsString(value));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("数据缓存至redis失败");
        }
    }

    /**
     * add 数据缓存至redis并设置过期时间
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, V> void add(K key, V value, long timeout, TimeUnit unit) {
        try {
            if (value != null) {
                redisTemplate.opsForValue().set(DEFAULT_KEY_PREFIX + key, objectMapper.writeValueAsString(value),
                    timeout, unit);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("数据缓存至redis失败");
        }
    }

    /**
     * addHashCache 写入 hash-set,已经是key-value的键值，不能再写入为hash-set
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, SK, V> void addHashCache(K key, SK subKey, V value) {
        redisTemplate.opsForHash().put(DEFAULT_KEY_PREFIX + key, subKey, value);
    }

    /**
     * addHashCache 写入 hash-set,并设置过期时间
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, SK, V> void addHashCache(K key, SK subKey, V value, long timeout, TimeUnit unit) {
        redisTemplate.opsForHash().put(DEFAULT_KEY_PREFIX + key, subKey, value);
        redisTemplate.expire(DEFAULT_KEY_PREFIX + key, timeout, unit);
    }

    /**
     * getHashCache 获取 hash-setvalue
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, SK> Object getHashCache(K key, SK subKey) {
        return redisTemplate.opsForHash().get(DEFAULT_KEY_PREFIX + key, subKey);
    }

    /**
     * getObject 从redis中获取缓存数据，转成对象
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, V> V getObject(K key) {
        String value = this.get(key);
        V result = null;
        if (!StringUtils.isEmpty(value)) {
            try {
                result = objectMapper.readValue(value, new TypeReference<V>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException("从redis缓存中获取缓存数据失败");
            }
        }
        return result;
    }

    /**
     * getList 从redis中获取缓存数据，转成list
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K, V> List<V> getList(K key) {
        String value = this.get(key);
        List<V> result = Collections.emptyList();
        if (!StringUtils.isEmpty(value)) {
            try {
                result = objectMapper.readValue(value, new TypeReference<List<V>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException("从redis缓存中获取缓存数据失败");
            }
        }
        return result;
    }

    /**
     * get 功能描述：Get the value of {@code key}.
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public <K> String get(K key) {
        String value;
        try {
            value = redisTemplate.opsForValue().get(DEFAULT_KEY_PREFIX + key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("从redis缓存中获取缓存数据失败");
        }
        return value;
    }

    /**
     * delete 删除key
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * delete 批量删除key
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * dump 序列化key
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public byte[] dump(String key) {
        return redisTemplate.dump(key);
    }

    /**
     * hasKey 是否存在key
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * expire 设置过期时间
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * expireAt 设置过期时间
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    /**
     * persist 移除 key 的过期时间，key 将持久保持
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    /**
     * getExpire 返回 key 的剩余的过期时间
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    /**
     * getExpire 返回 key 的剩余的过期时间
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/9/15
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }
}

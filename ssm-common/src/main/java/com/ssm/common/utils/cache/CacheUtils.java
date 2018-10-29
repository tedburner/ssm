package com.ssm.common.utils.cache;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: Lucifer
 * @date: 2018/10/27 18:43
 * @description:
 */
@Component
public class CacheUtils {

    private static JedisPool jedisPool = null;

    //写成静态代码块形式，只加载一次，节省资源
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(600);
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(300);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool(config, "118.25.108.65", 6379, 10000, "redis1230908");
    }

    /**
     * 从jedis连接池中获取获取jedis对象
     *
     * @return
     */
    private static Jedis getJedis() {
        return jedisPool.getResource();
    }

    private static final JedisUtils jedisUtils = new JedisUtils();


    /**
     * 获取 JedisUtils 实例
     */
    public static JedisUtils getInstance() {
        return jedisUtils;
    }

    public void returnJedis(Jedis jedis) {
        if (null != jedis && null != jedisPool) {
            jedisPool.destroy();
        }
    }

    /**
     * String 插入
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(key, value);
    }

    /**
     * String 插入
     *
     * @param field 前缀
     * @param key   拼接部分
     * @param value 保存的值
     */
    public void set(String field, String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(rawKey(field, key), value);
    }

    /**
     * String 插入,并将key的生存时间设为seconds(秒)
     *
     * @param field      前缀
     * @param key        拼接部分
     * @param value      保存的值
     * @param expireTime 过期时间
     */
    public void set(String field, String key, String value, int expireTime) {
        Jedis jedis = getJedis();
        jedis.setex(rawKey(field, key), expireTime, value);
        jedis.expire(key, expireTime);
    }

    /**
     * String 插入,并将key的生存时间设为seconds(秒)
     *
     * @param field      前缀
     * @param key        拼接部分
     * @param value      保存的值
     * @param expireTime 过期时间
     */
    public <T> void set(String field, String key, T value, int expireTime) {
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        String valueGson = gson.toJson(value);
        jedis.setex(rawKey(field, key), expireTime, valueGson);
        jedis.expire(key, expireTime);
    }


    /**
     * String 获取
     *
     * @param key
     */
    public String get(String key) {
        Jedis jedis = getJedis();
        return jedis.get(key);
    }

    /**
     * String 获取
     *
     * @param field 前缀
     * @param key   拼接
     */
    public String get(String field, String key) {
        Jedis jedis = getJedis();
        return jedis.get(rawKey(field, key));
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public String del(String key) {
        Jedis jedis = getJedis();
        return jedis.get(key);
    }

    /**
     * 删除 缓存
     *
     * @param field 前缀
     * @param key   拼接
     */
    public String del(String field, String key) {
        Jedis jedis = getJedis();
        return jedis.get(rawKey(field, key));
    }

    /**
     * 获取缓存有效时间
     *
     * @param field 前缀
     * @param key   拼接
     */
    public Long ttl(String field, String key) {
        Jedis jedis = getJedis();
        return jedis.ttl(rawKey(field, key));
    }


    /**
     * 生成redis中存储的实际key
     *
     * @param namespace
     * @param key
     * @return
     */
    protected String rawKey(String namespace, String key) {
        if (key == null || "".equals(key)) {
            return null;
        }
        return namespace + "_" + key;
    }
}

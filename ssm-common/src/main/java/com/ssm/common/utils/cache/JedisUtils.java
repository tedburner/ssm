package com.ssm.common.utils.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: Lucifer
 * @date: 2018/10/27 18:52
 * @description:
 */
public class JedisUtils {

    private static JedisPool pool;

    public static Jedis getPool() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(2);
        config.setMinIdle(2);
        config.setTestOnBorrow(true);
        config.setMaxWaitMillis(10000);
        config.setMinIdle(5);

        pool = new JedisPool(config, "192.168.33.120", 6379, 10000, "redis123456");
        return pool.getResource();
    }
}

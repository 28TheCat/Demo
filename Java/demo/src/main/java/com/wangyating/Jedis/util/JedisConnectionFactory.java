package com.wangyating.Jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static JedisPool jedisPool;
    static {
        //创建连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);//最大连接数
        config.setMaxIdle(8);//最大空闲连接
        config.setMinIdle(0);//最小空闲连接
        config.setMaxWaitMillis(1000);//最大等待时间

        //创建连接池对象
        jedisPool = new JedisPool(config,"192.168.1.100",6379,1000,"123456");

    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
    public static JedisPool getPool(){
        return jedisPool;
    }
}

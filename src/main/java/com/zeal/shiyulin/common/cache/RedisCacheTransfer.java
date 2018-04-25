package com.zeal.shiyulin.common.cache;

import com.zeal.shiyulin.common.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
*静态注入中间类
*@author  zeal
*@date 2017/12/8 19:31
*/
public class RedisCacheTransfer {


    @Autowired
    public  void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}

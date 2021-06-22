package com.cloud.alibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisPipelineServiceImpl {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void testPipeline(){
        String key = "test-redis-pipeline";
        List list =  stringRedisTemplate.executePipelined(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for(int i=0;i<1000000;i++){
                    redisConnection.lPush(key.getBytes(), "test".getBytes());
                }
                return null;
            }
        });
    }

}

package com.cloud.alibaba.service.impl;

import com.cloud.alibaba.service.IZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipKinServiceImpl implements IZipService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis pipelined
     */
    @Override
    public void logRedis() {
        String key = "test-redis-pipeline";
        List list =  stringRedisTemplate.executePipelined(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for(int i=0;i<1000000;i++){
                    redisConnection.lPush(key.getBytes(), String.valueOf(i).getBytes());
                }
                return null;
            }
        });
        stringRedisTemplate.opsForHash().put("Aibaba_zipkin_test","01","SUCCESS");
    }


}

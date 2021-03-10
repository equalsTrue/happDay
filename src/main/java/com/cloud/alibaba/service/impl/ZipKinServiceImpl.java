package com.cloud.alibaba.service.impl;

import com.cloud.alibaba.service.IZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ZipKinServiceImpl implements IZipService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void logRedis() {
        stringRedisTemplate.opsForHash().put("Aibaba_zipkin_test","01","SUCCESS");
    }
}

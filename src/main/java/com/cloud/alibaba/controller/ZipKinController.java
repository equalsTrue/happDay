package com.cloud.alibaba.controller;


import com.cloud.alibaba.service.IZipService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author david
 */
@RestController
@Slf4j
public class ZipKinController {

    @Autowired
    private OkHttpClient client;


    @Autowired
    private IZipService service;


    @RequestMapping(value = "/test/zipkin/method1")
    public String testZipKin(HttpServletRequest httpRequest) throws IOException {
        log.info("TEST :{}", "SUCCESS");
        service.logRedis();
        return "success";
    }


}

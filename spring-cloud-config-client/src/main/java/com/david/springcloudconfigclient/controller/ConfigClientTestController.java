package com.david.springcloudconfigclient.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientTestController {

    @Value("${info}")
    String info;


    @RequestMapping(value = "/hi")
    public String hi(){
        return info;
    }

}

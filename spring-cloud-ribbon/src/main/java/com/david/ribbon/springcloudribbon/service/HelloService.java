package com.david.ribbon.springcloudribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String helloService(String name){
        return restTemplate.getForObject("http://service-david/hello?name=" + name,String.class);
    }

}

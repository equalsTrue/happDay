package com.david.springcloudfegin.controller;

import com.david.springcloudfegin.service.IfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FeignController {

    @Autowired
    IfeignService service;

    @GetMapping(value = "/feign/hello")
    public String feignHello(@RequestParam String name){
        return service.helloService(name);
    }

}

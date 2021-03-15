package com.david.ribbon.springcloudribbon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.david.ribbon.springcloudribbon.service.HelloService;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    HelloService service;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name){
        return service.helloService(name);
    }
}

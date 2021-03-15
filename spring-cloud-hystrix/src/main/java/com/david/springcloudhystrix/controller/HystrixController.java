package com.david.springcloudhystrix.controller;


import com.david.springcloudhystrix.service.IFeignHystrixService;
import com.david.springcloudhystrix.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HystrixController {

    @Autowired
    RibbonHystrixService service;

    @Autowired
    IFeignHystrixService IFeignHystrixService;


    @GetMapping(value = "/ribbon/hystrix")
    public String ribbonHystrix(@RequestParam String name){
        return service.ribbonService(name);
    }

    @GetMapping(value = "/feign/hystrix")
    public String feignHystrix(@RequestParam String name){
        return IFeignHystrixService.feignHystrixServiceError(name);
    }
}

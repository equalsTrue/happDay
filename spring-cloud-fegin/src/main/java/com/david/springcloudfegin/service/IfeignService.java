package com.david.springcloudfegin.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient 为注册server的名称
 * @author david
 */
@FeignClient(value = "service-david")
public interface IfeignService {

    /**
     * 映射为注册server的方法
     * @param name
     * @return
     */
    @GetMapping(value = "/hello")
    String helloService(@RequestParam(value = "name")String name );
}

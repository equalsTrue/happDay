package com.david.springcloudhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-david",fallback = FeignHystrixServiceImpl.class)
public interface IFeignHystrixService {

    @GetMapping(value = "/hello")
    String feignHystrixServiceError(@RequestParam String name);
}

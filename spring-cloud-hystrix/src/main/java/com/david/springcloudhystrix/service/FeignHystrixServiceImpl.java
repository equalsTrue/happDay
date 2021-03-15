package com.david.springcloudhystrix.service;

import org.springframework.stereotype.Service;

@Service
public class FeignHystrixServiceImpl implements IFeignHystrixService {

    @Override
    public String feignHystrixServiceError(String name) {
        return "Hello, Feign " +name +" call error";
    }
}

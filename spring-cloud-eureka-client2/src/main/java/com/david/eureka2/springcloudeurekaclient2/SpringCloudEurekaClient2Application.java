package com.david.eureka2.springcloudeurekaclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClient2Application.class, args);
    }

}

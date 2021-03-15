package com.david.springcloudhystrix.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 将请求用HystrixCommand 包裹
     * fallbackMethod 失败返回方法
     * threadPoolProerties 线程池配置  coresize 线程池大小   queueSizeRejectThreshold 缓冲区降级阈值
     * commandProperties command 配置 超时时间大于配置的timeout接口返回时间
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "ribbonError",groupKey = "AnnotationHystrixInvoke",commandKey = "getInfo",threadPoolKey = "david-pool",
            threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value= "30"),
            @HystrixProperty(name = "queueSizeRejectionThreshold",value = "20")
    },commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    public String ribbonService(String name){
        return restTemplate.getForObject("http://service-david/hello?name=" + name,String.class);
    }

    public String getInfo() {
        System.out.println(Thread.currentThread().getName() + "开始执行getInfo");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("捕获到异常" + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + "仍在执行getInfo");
        return "hello";
    }

    public String ribbonError(String name){
        return "Hi ," +name + "ribbon Hystrix error";
    }

}

package com.cloud.alibaba.config;

import com.codahale.metrics.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author david
 */
@Configuration
public class MetricConfig {

    /**
     * 创建注册中心
     * @return
     */
    @Bean
    public MetricRegistry registry(){
        return new MetricRegistry();
    }



    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry registry){
        return ConsoleReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.SECONDS)
                .build();
    }

    /**
     * 创建Meters TPS
     * @param registry
     * @return
     */
    @Bean
    public Meter requestMeter(MetricRegistry registry){
        return registry.meter("request-TPS");
    }

    @Bean
    public Histogram histogram(MetricRegistry registry){
        return registry.histogram("response-size");
    }

    @Bean
    public Counter counter(MetricRegistry registry){
        return registry.counter("request-Counter");
    }

    @Bean
    public Timer timer(MetricRegistry registry){
        return registry.timer("request-timer");
    }
}

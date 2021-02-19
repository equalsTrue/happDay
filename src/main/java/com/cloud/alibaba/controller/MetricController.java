package com.cloud.alibaba.controller;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class MetricController {

    @Autowired
    private Meter requestMeter;

    @Autowired
    private Histogram responseSizes;

    @Autowired
    private Counter pendingJobs;

    @Autowired
    private Timer timer;


    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {

        requestMeter.mark();

        pendingJobs.inc();

        responseSizes.update(new Random().nextInt(10));


        final Timer.Context context = timer.time();
        try {
            return "Hello World";
        } finally {
            context.stop();
        }
    }
}

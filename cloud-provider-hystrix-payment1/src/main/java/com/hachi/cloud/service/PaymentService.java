package com.hachi.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author hachi
 * @date 10/11/20 10:02 AM
 */
@Service
@DefaultProperties(defaultFallback = "common_fallback")
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "Thread Pool: " + Thread.currentThread().getName() + " paymentInfo_OK, id = " + id;
    }

    // @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler", commandProperties = {
    //     @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    // })
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id) {
        // int a = 10/ 0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread Pool: " + Thread.currentThread().getName() + " paymentInfo_TimeOut, id = " + id;
    }

    public String paymentInfo_Timeout_Handler(Integer id) {
        return "Thread Pool: " + Thread.currentThread().getName() + " TimeOut.......... Please Try it later";
    }

    public String common_fallback() {
        return "Provider Common fallback: --------";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                          // 开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),             // 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),       // 时间
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),           // 失败率
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id can not be negative");
        }
        return "Thread Pool: " + Thread.currentThread().getName() + " success, serial num is " + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "paymentCircuitBreaker_fallback";
    }
}

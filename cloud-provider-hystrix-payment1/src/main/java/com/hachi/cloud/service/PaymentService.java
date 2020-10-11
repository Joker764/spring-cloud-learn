package com.hachi.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author hachi
 * @date 10/11/20 10:02 AM
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "Thread Pool: " + Thread.currentThread().getName() + " paymentInfo_OK, id = " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
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
}

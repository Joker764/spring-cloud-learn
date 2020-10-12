package com.hachi.cloud.controller;

import com.hachi.cloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hachi
 * @date 10/11/20 10:55 AM
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return orderService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_fallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return orderService.paymentInfo_Timeout(id);
    }

    public String paymentInfo_fallback(@PathVariable("id") Integer id) {
        return "Consumer Timeout, Please try it later... -_-";
    }
}

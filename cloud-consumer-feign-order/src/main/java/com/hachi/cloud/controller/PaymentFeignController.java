package com.hachi.cloud.controller;

import com.hachi.cloud.entity.CommonResult;
import com.hachi.cloud.entity.Payment;
import com.hachi.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hachi
 * @date 10/8/20 10:01 PM
 */
@RestController
public class PaymentFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout() {
        return paymentFeignService.paymentTimeout();
    }
}

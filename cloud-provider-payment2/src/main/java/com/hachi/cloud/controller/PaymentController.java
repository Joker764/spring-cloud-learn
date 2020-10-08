package com.hachi.cloud.controller;

import com.hachi.cloud.service.PaymentService;
import com.hachi.cloud.entity.CommonResult;
import com.hachi.cloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author hachi
 * @date 10/3/20 2:52 PM
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("Result: " + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功 Server port: " + serverPort, payment);
        } else {
            return new CommonResult<>(400, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("Result: " + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功 Server port: " + serverPort, payment);
        } else {
            return new CommonResult<>(400, "查询失败");
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}

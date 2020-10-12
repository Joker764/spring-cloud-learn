package com.hachi.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hachi
 * @date 10/11/20 10:53 AM
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OrderFallbackService.class)
public interface OrderService {

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);
}

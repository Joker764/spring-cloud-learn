package com.hachi.cloud.service;

import org.springframework.stereotype.Service;

/**
 * @author hachi
 * @date 10/12/20 7:26 PM
 */
@Service
public class OrderFallbackService implements OrderService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "fallback ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "fallback timeout";
    }
}

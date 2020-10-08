package com.hachi.cloud.service;

import com.hachi.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author hachi
 * @date 10/3/20 2:48 PM
 */
public interface PaymentService {

    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}

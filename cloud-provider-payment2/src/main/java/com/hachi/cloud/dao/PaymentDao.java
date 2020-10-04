package com.hachi.cloud.dao;

import com.hachi.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hachi
 * @date 10/3/20 2:25 PM
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}

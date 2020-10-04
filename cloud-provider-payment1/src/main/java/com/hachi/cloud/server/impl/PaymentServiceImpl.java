package com.hachi.cloud.server.impl;

import com.hachi.cloud.dao.PaymentDao;
import com.hachi.cloud.entity.Payment;
import com.hachi.cloud.server.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hachi
 * @date 10/3/20 2:48 PM
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

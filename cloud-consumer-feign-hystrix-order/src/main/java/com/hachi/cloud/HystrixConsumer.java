package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hachi
 * @date 10/11/20 10:51 AM
 */
@SpringBootApplication
@EnableFeignClients
public class HystrixConsumer {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumer.class, args);
    }
}

package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hachi
 * @date 10/11/20 9:59 AM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixProvider1 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProvider1.class, args);
    }
}

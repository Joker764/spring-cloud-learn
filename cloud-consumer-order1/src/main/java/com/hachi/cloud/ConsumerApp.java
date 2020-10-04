package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hachi
 * @date 10/4/20 12:29 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class);
    }
}

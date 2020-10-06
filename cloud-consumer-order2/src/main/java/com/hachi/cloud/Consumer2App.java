package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hachi
 * @date 10/6/20 11:07 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer2App {

    public static void main(String[] args) {
        SpringApplication.run(Consumer2App.class, args);
    }
}

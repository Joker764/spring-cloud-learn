package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hachi
 * @date 10/6/20 10:13 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider4App {

    public static void main(String[] args) {
        SpringApplication.run(Provider4App.class, args);
    }
}

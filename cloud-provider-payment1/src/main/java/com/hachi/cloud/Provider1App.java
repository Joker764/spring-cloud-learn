package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hachi
 * @date 10/3/20 2:11 PM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Provider1App {

    public static void main(String[] args) {
        SpringApplication.run(Provider1App.class);
    }
}

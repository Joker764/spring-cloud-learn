package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hachi
 * @date 10/4/20 11:56 PM
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2.class);
    }
}

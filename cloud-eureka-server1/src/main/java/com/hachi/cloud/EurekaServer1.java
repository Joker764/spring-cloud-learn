package com.hachi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hachi
 * @date 10/4/20 7:28 PM
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer1 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1.class);
    }
}

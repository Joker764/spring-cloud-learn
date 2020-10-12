package com.hachi.cloud;

import com.alibaba.druid.support.http.StatViewServlet;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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

    @Bean
    public ServletRegistrationBean getServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}

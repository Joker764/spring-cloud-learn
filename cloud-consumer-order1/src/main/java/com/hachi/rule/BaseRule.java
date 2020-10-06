package com.hachi.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hachi
 * @date 10/6/20 12:59 PM
 */
@Configuration
public class BaseRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}

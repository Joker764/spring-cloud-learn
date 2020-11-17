package com.hachi.could.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_1", r -> r.path("/guonei").uri("https://news.baidu.com/guonei"))
                .route("path_route_1", r -> r.path("/guoji").uri("https://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }
}

package com.company.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator RouteInit(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("user-path-route", r -> r.path("/user-service/**")
                        .uri("lb://user-service"))
                .route("basket-path-route", r -> r.path("/basket-service/**")
                        .uri("lb://basket-service"))
                .build();
    }
}
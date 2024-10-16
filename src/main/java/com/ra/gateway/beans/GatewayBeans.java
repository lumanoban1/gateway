package com.ra.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans {

    @Bean
    @Profile(value="eureka-off")
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(route -> route
                        .path("/producto-crud/producto/**")
                        .uri("http://localhost:8081")
                )
                .build();
    }

    @Bean
    @Profile(value="eureka-on")
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(route -> route
                        .path("/producto-crud/producto/**")
                        .uri("lb://producto-crud")
                )
                .build();
    }
}

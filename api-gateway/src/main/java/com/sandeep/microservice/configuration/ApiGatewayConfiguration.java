package com.sandeep.microservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
		
		return routeLocatorBuilder.routes()
		.route(p->p.path("/loan/**").uri("lb://loan-service"))
		.route(p->p.path("/quote/**").uri("lb://quote-service"))
		.build();
		
	}

}

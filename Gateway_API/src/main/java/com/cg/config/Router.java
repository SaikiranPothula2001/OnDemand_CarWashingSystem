package com.cg.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Router {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				
				.route(r->r.path("/user/**")
				.uri("http://localhost:9091"))
				
				.route(r->r.path("/washer/**")
				.uri("http://localhost:9092"))
				
				.route(r->r.path("/washpack/**")
				.uri("http://localhost:9093"))
				
				.route(r->r.path("/admin/**")
				.uri("http://localhost:8888"))
				
				.build();
	}

}

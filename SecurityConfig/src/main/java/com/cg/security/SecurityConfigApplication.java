package com.cg.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.cg.security.client")
@ComponentScan("com.cg.*")
public class SecurityConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityConfigApplication.class, args);
		System.out.println("security is running");
	}

}

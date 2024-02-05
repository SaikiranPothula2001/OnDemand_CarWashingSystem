package com.cg.WasherService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cg.WasherService.*"})
public class WasherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasherServiceApplication.class, args);
		System.out.println("Washer Service is Running");
	}

}

//package com.cg.config;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//
//
//@Configuration
//@EnableSwagger2
//
//public class SpringFoxConfig {
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.any())
//				.apis(RequestHandlerSelectors.any())
//				.build()
//				.apiInfo(apiInfo());
//	}
//	private ApiInfo apiInfo() {
//	    return new ApiInfo(
//	      "My REST API for USER SERVICE",
//	      "Some custom description of API.",
//	      "1.0",
//	      "Terms of service",
//	      new Contact("xxxx", "xxxxxxx", "xxxxxx@gmail.com"),
//	      "License of API",
//	      "API license URL",
//	      Collections.emptyList());
//
//}
//}

package com.cg.WashPackService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WashPackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WashPackServiceApplication.class, args);
		System.out.println("WashPack Service is Running");
	}
	
	
	
//	   @Bean
//	    public Docket swaggerConfiguration() {
//	       return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
//	                .apis(RequestHandlerSelectors.basePackage("com.bug.tracking.controller")).build().apiInfo(apiInfo());
//	   }
//
//	   private ApiInfo apiInfo() {       
//	        return new ApiInfoBuilder().title("Bug Tracker")
//	                .description("Bug Tracking website")
//	                .termsOfServiceUrl("http://bugtrack.com/")
//	                
//	                .licenseUrl("bugtrack@gmail.com").version("1.0").build();
//	    }

	}



package com.healthhistoryservice.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.healthservice.demo.exceptionhandler.GlobalExceptionHandler;

@Configuration
public class AppConfig {
	
	
	 @Bean 
	 RestTemplate getRestTemplate() { 
		 return new RestTemplate(); 
	}
	 
	  @Bean
	  GlobalExceptionHandler globalExceptionHandler() {
	        return new GlobalExceptionHandler();
	   }
	
	

}

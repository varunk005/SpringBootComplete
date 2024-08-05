package com.spc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class Configcc {

	@Bean
	public OpenAPI basicOpenAPI() {
		
		return new OpenAPI().info(new Info().title("Emplyee ").version("1.00").description("Emplu=yedetails"));
	}
	
}

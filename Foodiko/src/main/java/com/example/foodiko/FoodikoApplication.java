package com.example.foodiko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(
		title="Foodiko",
		version="1.1.2",
		description="Food Ordering App"))
public class FoodikoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodikoApplication.class, args);
	}

}

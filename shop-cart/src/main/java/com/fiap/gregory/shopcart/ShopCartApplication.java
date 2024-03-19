package com.fiap.gregory.shopcart;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fiap.gregory.*"})
@EntityScan(basePackages = {"com.fiap.gregory.*"})
@EnableJpaRepositories(basePackages = {"com.fiap.gregory.*"})
@OpenAPIDefinition(info = @Info(title = "Shopping Cart Module", version = "1.0",
		description = "This is an API that will allow you to manage shopping carts"))
public class ShopCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopCartApplication.class, args);
	}

}

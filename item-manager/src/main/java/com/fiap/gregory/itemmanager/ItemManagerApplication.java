package com.fiap.gregory.itemmanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fiap.gregory.itemmanager.*"})
@EntityScan(basePackages = {"com.fiap.gregory.itemmanager.*"})
@EnableJpaRepositories(basePackages = {"com.fiap.gregory.itemmanager.*"})
@OpenAPIDefinition(info = @Info(title = "Item Manager Module", version = "1.0",
		description = "This is an API that will allow you to manage items"))
public class ItemManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemManagerApplication.class, args);
	}

}

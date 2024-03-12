package com.fiap.gregory.client;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.fiap.gregory.client.infra.db.model")
@EnableJpaRepositories(basePackages = "com.fiap.gregory.client.infra.db.repository")
@OpenAPIDefinition(info = @Info(title = "Client Module", version = "1.0",
		description = "This is an API that will allow you to manage clients"))
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}

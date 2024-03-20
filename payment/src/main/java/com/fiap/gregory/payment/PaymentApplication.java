package com.fiap.gregory.payment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fiap.gregory.payment.*"})
@EntityScan(basePackages = {"com.fiap.gregory.payment.*"})
@EnableJpaRepositories(basePackages = {"com.fiap.gregory.payment.*"})
@OpenAPIDefinition(info = @Info(title = "Payment Module", version = "1.0",
		description = "This is an API that will allow you to complete your purchase and make payment"))
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}

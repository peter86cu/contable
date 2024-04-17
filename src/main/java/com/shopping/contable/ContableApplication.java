package com.shopping.contable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContableApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContableApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}
}

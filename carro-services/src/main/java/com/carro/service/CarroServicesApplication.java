package com.carro.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarroServicesApplication.class, args);
	}

}

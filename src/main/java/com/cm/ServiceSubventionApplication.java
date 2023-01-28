package com.cm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.cm")
public class ServiceSubventionApplication{

	public static void main(String[] args) {
		SpringApplication.run(ServiceSubventionApplication.class, args);
	}

}

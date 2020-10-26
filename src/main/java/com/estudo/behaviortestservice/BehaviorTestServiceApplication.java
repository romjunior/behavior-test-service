package com.estudo.behaviortestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BehaviorTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BehaviorTestServiceApplication.class, args);
	}

}

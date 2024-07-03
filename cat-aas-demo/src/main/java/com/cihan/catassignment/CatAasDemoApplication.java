package com.cihan.catassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatAasDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatAasDemoApplication.class, args);
	}

}

package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shop"})
public class NimapApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapApplication.class, args);
	}

}

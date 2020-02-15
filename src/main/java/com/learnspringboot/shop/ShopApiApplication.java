package com.learnspringboot.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShopApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopApiApplication.class, args);
	}

}

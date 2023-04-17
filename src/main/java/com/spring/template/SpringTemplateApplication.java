package com.spring.template;

import org.hibernate.loader.ast.spi.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringTemplateApplication.class, args);
		System.out.println("hello");
	}

}

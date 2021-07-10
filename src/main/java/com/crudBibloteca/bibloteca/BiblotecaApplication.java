package com.crudBibloteca.bibloteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.crudBibloteca.bibloteca"})
@EnableAutoConfiguration
public class BiblotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblotecaApplication.class, args);
	}

}

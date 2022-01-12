package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Load of application context.
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.example" })
public class ServletLoader {

	public static void main(String[] args) {
		SpringApplication.run(ServletLoader.class, args);
	}
}

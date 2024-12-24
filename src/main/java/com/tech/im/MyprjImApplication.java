package com.tech.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyprjImApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyprjImApplication.class, args);
	}

}

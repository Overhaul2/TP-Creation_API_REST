package com.quizapi.ApiQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuizApplication.class, args);
		System.out.println("Hello world");
	}

}

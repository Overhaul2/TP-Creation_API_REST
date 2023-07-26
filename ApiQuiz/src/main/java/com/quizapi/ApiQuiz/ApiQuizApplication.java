package com.quizapi.ApiQuiz;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ApiQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuizApplication.class, args);
		System.out.println("Hello world");
	}

}

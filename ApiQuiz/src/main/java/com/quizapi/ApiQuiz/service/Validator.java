package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.User;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

public class Validator {


        public static boolean Email(String email) {
            return StringUtils.hasText(email) && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        }


}

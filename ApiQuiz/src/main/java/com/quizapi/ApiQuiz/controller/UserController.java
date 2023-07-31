package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.repository.UserRepository;
import com.quizapi.ApiQuiz.service.UserApp;
import com.quizapi.ApiQuiz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    //@GetMapping("/test")
    //public String lonpo(){
      //  return "Bienvenue chez lonpo";
    //}

    @GetMapping("/profile")
    public Optional<User> lire(){
        return userService.finduser();
    }

    @DeleteMapping("/delete")
    @Transactional
    public String delete(){
        return userService.deletesuser();
    }
}

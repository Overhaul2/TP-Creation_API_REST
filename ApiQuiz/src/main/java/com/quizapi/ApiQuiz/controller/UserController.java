package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    //@GetMapping("/test")
    //public String lonpo(){
      //  return "Bienvenue chez lonpo";
    //}

    @GetMapping("/profile")
    public Optional<User> lire(){
        return userService.finduser();
    }
    @Transactional
    @DeleteMapping("/delete")
    public String delete(){
        return userService.deletesuser();
    }
}

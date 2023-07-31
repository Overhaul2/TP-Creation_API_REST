package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.repository.UserRepository;
import com.quizapi.ApiQuiz.service.UserApp;
import com.quizapi.ApiQuiz.service.UserService;
import com.quizapi.ApiQuiz.service.User_Update;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public Optional<User> profile(){
        return userService.finduser();
    }

    @DeleteMapping("/delete")
    @Transactional
    public String delete(){
        return userService.deletesuser();
    }
    @PatchMapping("/update")
    public ResponseEntity<String> update(@Valid @RequestBody User_Update data){
        return userService.modify(data);
    }
}

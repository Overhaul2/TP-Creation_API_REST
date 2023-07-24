package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String bienvenue(){
        return "Bienvenue sur notre API de Creation et de Jeux de Quiz";
    }
    @PostMapping("/creer")
    public ResponseEntity<String> creer(@RequestBody User user){
        return userService.saveUser(user);

    }

    @GetMapping ("/infos/{id}")
    public Optional<User> lire(@PathVariable long id){
        return userService.finduser(id);
    }
}

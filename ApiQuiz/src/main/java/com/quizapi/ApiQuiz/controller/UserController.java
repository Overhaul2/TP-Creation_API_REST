package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import lombok.AllArgsConstructor;
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
    public String creer(@RequestBody User user){
         userService.saveUser(user);
         return "Donnee sauvegarder";
    }

    @GetMapping ("/infos/{id}")
    public Optional<User> lire(@PathVariable long id){
        return userService.finduser(id);
    }
}

package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api")
@AllArgsConstructor
public class PublicController {
    private final UserService userService;

    @GetMapping("/")
    public String bienvenue(){
        return "Bienvenue sur notre API de Creation et de Jeux de Quiz";
    }
    @PostMapping("/registration")
    public ResponseEntity<String> creer(@Valid @RequestBody User user, Errors errors) throws BindException {
            if (errors.hasErrors()) {
                return new ResponseEntity("Nous sommes desole L'operation demande ne peut pas etre execute Veuillez saisir de valeur correct", HttpStatus.BAD_REQUEST);
            }

        return userService.saveUser(user);

    }

}

package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Participation;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import com.quizapi.ApiQuiz.service.User_Update;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    //@GetMapping("/test")
    //public String lonpo(){
      //  return "Bienvenue chez lonpo";
    //}
    @GetMapping("/profile")
    public Optional<User> profile(){
        return userService.finduser();
    }
    @Transactional
    @DeleteMapping("/delete")
    public String delete(){
        return userService.deletesuser();
    }

    @GetMapping("/History/{UserId}")
    @Operation(summary = "afficher l'historique", description = "azertyui")

    public ResponseEntity<List<Participation>> getUserParticipation(@PathVariable("UserId") Long UserId){
        List<Participation> ParticipationList= getUserParticipationFromDataSource(UserId);
        return ResponseEntity.ok(ParticipationList);
    }

    private List<Participation> getUserParticipationFromDataSource(Long UserId){
        List<Participation> ParticipationList= new ArrayList<>();
        return ParticipationList;}
    @PatchMapping("/update")
    public ResponseEntity<String> update(@Valid @RequestBody User_Update data) {
        return userService.modify(data);

    }
    }

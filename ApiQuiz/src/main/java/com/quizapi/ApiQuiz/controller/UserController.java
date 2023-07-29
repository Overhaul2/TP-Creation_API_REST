package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Participation;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @DeleteMapping("/delete")
    public String delete(){
        return userService.deletesuser();
    }

    @GetMapping("/History/{UserId}")
    public ResponseEntity<List<Participation>> getUserParticipation(@PathVariable("UserId") Long UserId){
        List<Participation> ParticipationList= getUserParticipationFromDataSource(UserId);
        return ResponseEntity.ok(ParticipationList);
    }

    private List<Participation> getUserParticipationFromDataSource(Long UserId){
        List<Participation> ParticipationList= new ArrayList<>();
        return ParticipationList;
    }
}

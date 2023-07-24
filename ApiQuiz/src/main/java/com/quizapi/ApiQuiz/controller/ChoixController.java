package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Choix;
import com.quizapi.ApiQuiz.service.Choixservice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("choix")
@AllArgsConstructor
public class ChoixController {
    private Choixservice choixservice;

    @PostMapping("/create")
    public Choix create(@RequestBody Choix choix){
        return choixservice.creer(choix);
    }

    @GetMapping("/liste")
    public List<Choix> read(){
        return choixservice.lire();
    }

    @PutMapping("/update/{id}")
    public Choix update(@PathVariable Long id, @RequestBody Choix choix){
        return choixservice.modifier(id, choix);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id){
        return choixservice.supprimer(id);
    }

}

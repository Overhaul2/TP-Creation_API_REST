package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Choix;
import com.quizapi.ApiQuiz.service.Choixservice;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("choix")
@AllArgsConstructor
public class ChoixController {
    private Choixservice choixservice;

    @PostMapping("/create")
    @Operation(summary = "Créer le choix de quiz ", description = "cette methode permet de créer le choix de quiz")
    public Choix create(@RequestBody Choix choix){
        return choixservice.creer(choix);
    }

    @GetMapping("/liste")
    @Operation(summary = "Afficher la liste des choix ", description = "cette methode permet d'afficher une liste de choix'")
    public List<Choix> read(){
        return choixservice.lire();
    }

    @PutMapping("/update/{id}")
    public Choix update(@PathVariable Long id, @RequestBody Choix choix){
        return choixservice.modifier(id, choix);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return choixservice.supprimer(id);
    }

}

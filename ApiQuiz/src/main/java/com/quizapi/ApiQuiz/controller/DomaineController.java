package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Choix;
import com.quizapi.ApiQuiz.modele.Domaine;
import com.quizapi.ApiQuiz.service.DomaineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("domaine")
@AllArgsConstructor
public class DomaineController {

    private DomaineService domaineService;

    @PostMapping("/create")
    public Domaine create(@RequestBody Domaine domaine){
        return domaineService.creer(domaine);
    }

    @GetMapping("/liste")
    public List<Domaine> read(){
        return domaineService.lire();
    }

    @PutMapping("/update/{idDomaine}")
    public Domaine update(@PathVariable int idDomaine, @RequestBody Domaine domaine){
        return domaineService.modifier(idDomaine,domaine);
    }

    @DeleteMapping("/supprimer/{idDomaine}")
    public String delete(@PathVariable Long idDomaine){
        return domaineService.supprimer(idDomaine);
    }

}

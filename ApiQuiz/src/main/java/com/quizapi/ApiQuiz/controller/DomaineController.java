package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Choix;
import com.quizapi.ApiQuiz.modele.Domaine;
import com.quizapi.ApiQuiz.service.DomaineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("domaine")
@AllArgsConstructor
public class DomaineController {

    private DomaineService domaineService;

    @PostMapping("/create")
    @ApiOperation(value = "créer un domaine", notes = "cette methode permet de créer un domaine" , response = Domaine.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "Le Domaine a été créer dans la base de donnée")
    })
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

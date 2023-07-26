package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/create")
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.creer(quiz);
    }

    @GetMapping("/liste")
    public List<Quiz> read() {
        return quizService.lire();
    }

    @PutMapping("/update/{idQz}")
    public Quiz update(@PathVariable Long idQz, @RequestBody Quiz quiz) {
        return quizService.modifier(idQz, quiz);
    }

    @DeleteMapping("/delete/{idQz}")
    @Operation(summary = "Supprimer quiz ", description = "cette methode permet de Supprimer quiz")
    public String delete(@PathVariable Long idQz) {
        return quizService.supprimer(idQz);
    }

    @GetMapping("/rechercher")
    @Operation(summary = "Recherche de quiz ", description = "cette methode permet de Rechercher des quiz selon le domaine de connaissance")
    public ResponseEntity<List<String>> searching(@RequestParam(value = "domain") String domain) {
        List<Quiz> quizList = quizService.search(domain);
        List<String> quizNames = new ArrayList<>();

        for (Quiz quiz : quizList) {
            quizNames.add(quiz.getNom());
        }


        return ResponseEntity.ok(quizNames);
//voyons si tout a change

    }
}

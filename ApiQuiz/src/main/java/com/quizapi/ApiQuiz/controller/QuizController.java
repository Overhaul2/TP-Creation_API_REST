package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
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
    @Operation(summary = "Recherche de quiz", description = "Cette méthode permet de rechercher des quiz selon le domaine de connaissance")
    public ResponseEntity<List<Map<String, Object>>> searching(@RequestParam(value = "domain") String domain) {
        List<Quiz> quizList = quizService.search(domain);
        List<Map<String, Object>> quizInfoList = new ArrayList<>();

        for (Quiz quiz : quizList) {
            Map<String, Object> quizInfo = new HashMap<>();
            quizInfo.put("id", quiz.getId());
            quizInfo.put("nom", quiz.getNom());
            quizInfoList.add(quizInfo);
        }
//voyons si tout a change
        return ResponseEntity.ok(quizInfoList);
    }

}

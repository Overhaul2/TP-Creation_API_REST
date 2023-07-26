package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String delete(@PathVariable Long idQz) {
        return quizService.supprimer(idQz);
    }

    @GetMapping("/rechercher")
    public ResponseEntity<List<Quiz>> searching(@RequestParam(value = "domain") String domain) {
        List<Quiz> quiz = quizService.search(domain);
        return ResponseEntity.ok(quiz);
    }
}

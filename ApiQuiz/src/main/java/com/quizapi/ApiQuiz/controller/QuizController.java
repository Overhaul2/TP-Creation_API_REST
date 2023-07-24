package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {
    private QuizService quizService;

    @PostMapping("/create")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.creer(quiz);
    }

    @GetMapping("/liste")
    public List<Quiz> read(){
        return quizService.lire();
    }

    @PutMapping("/update")
    public Quiz update(@RequestBody Long idQz, Quiz quiz){

        return quizService.modifier(idQz, quiz);
    }

    public String delete(@PathVariable Long idQz){

        return quizService.supprimer(idQz);
    }
}

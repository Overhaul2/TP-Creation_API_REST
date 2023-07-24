package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Question;
import com.quizapi.ApiQuiz.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @PostMapping("/create")
    public Question create(@RequestBody Question question){
        return questionService.creer(question);
    }

    @GetMapping("/list")
    public List<Question> read(){
        return questionService.lire();
    }

    @PutMapping("/update")
    public Question update(@PathVariable Long idQ, Question question){
        return questionService.modifier(idQ, question);
    }

    @DeleteMapping("/supprime")
    public String delete(@PathVariable Long idQ){
        return questionService.supprimer(idQ);
    }
}

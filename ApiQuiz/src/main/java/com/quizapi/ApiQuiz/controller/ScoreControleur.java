package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.modele.Score;
import com.quizapi.ApiQuiz.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("score")
public class ScoreControleur {

    private ScoreService scoreService;

    public ScoreControleur(ScoreService scoreService){
        this.scoreService = scoreService;
    }

    @PostMapping("/create")

    public Score create(@RequestBody Score score) {
        return scoreService.creer(score);
    }

    @GetMapping("/liste")
    @ResponseBody
    public List<Score> read() {
        return scoreService.lire();
    }
}

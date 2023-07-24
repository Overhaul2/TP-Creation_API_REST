package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Score;

import java.util.List;

public interface ScoreService {

    Score creer(Long id, Long idQz, int point);

    List<Score> lire();

}

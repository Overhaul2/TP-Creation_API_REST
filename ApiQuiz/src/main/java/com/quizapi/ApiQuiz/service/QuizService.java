package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Quiz;

import java.util.List;

public interface QuizService {
    Quiz creer(Quiz quiz);

    List<Quiz> lire();

    Quiz modifier(Long idQ, Quiz quiz);

    String supprimer(Long idQz);
}

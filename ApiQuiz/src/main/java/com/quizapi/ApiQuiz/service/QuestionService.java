package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Question;
import com.quizapi.ApiQuiz.modele.Quiz;

import java.util.List;

public interface QuestionService {

    Question creer(Question question);

    List<Question> lire();

    Question modifier(Long idQ, Question question);

    String supprimer(Long idQ);

    List<Quiz> rechercherQuizByNom(String nom);
}

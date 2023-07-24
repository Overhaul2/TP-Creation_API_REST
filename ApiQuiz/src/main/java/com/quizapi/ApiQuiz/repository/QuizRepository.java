package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}

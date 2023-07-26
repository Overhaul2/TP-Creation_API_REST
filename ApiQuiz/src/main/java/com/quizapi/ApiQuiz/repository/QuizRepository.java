package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
 
    List<Quiz> findByDomaine_Nom(String domaine);

    List<Quiz> findByNomContainingIgnoreCase(String nom);
}

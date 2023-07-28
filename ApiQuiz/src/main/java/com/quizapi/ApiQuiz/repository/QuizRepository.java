package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
 
    List<Quiz> findByDomaine_Nom(String domaine);

    List<Quiz> findByNomContainingIgnoreCase(String nom);
    List<Quiz> findQuizByUser_Email(String email);

    @Query("SELECT q.user FROM Quiz q WHERE q.id = :quizId")
    User findUserById(@Param("quizId") Long quizId);

}

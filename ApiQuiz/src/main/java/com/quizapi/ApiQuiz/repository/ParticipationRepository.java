package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Participation;
import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Long> {

    Participation findParticipationByUserAndAndQuiz(User user, Quiz quiz);
}

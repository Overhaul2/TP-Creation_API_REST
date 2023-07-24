package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Choix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiRepository extends JpaRepository<Choix, Long>{
}

package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine, Long> {
}

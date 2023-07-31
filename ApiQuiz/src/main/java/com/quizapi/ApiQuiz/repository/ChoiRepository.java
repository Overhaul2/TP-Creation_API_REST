package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Choix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoiRepository extends JpaRepository<Choix, Long>{
    List<Choix> findAllByQuestion_Id(Long id);
    void deleteById(Long id);
}

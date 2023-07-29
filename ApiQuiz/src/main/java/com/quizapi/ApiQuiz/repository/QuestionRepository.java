package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByQuiz_Id(Long id);
    Question findQuestionById(Long id);
}

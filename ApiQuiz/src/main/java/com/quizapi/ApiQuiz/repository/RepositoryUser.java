package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User, Long> {
}

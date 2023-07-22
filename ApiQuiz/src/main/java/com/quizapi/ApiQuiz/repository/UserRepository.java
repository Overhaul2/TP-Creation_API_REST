package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

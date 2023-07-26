package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPseudo(String pseudo);
    Optional<User> findByEmail(String email);
    Boolean deleteByEmail(String email);

}

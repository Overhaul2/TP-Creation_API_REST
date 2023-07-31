package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Participation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;


import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
@Component

    public interface ParticipationRepository extends JpaRepository<Participation,Long> {

    Participation findParticipationByUserAndAndQuiz(User user, Quiz quiz);

    /*private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParticipationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Participation> getParticipationsByUserId(Integer userId) ;
    {
        String sqlQuery = "SELECT * FROM participations WHERE user_id = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{userId}, new BeanPropertyRowMapper<>(Participation.class));
    }*/
}

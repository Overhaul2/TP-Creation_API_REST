package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Participation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Component
public class ParticipationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParticipationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Participation> getParticipationsByUserId(Integer userId) {
        String sqlQuery = "SELECT * FROM participations WHERE user_id = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{userId}, new BeanPropertyRowMapper<>(Participation.class));
    }
}

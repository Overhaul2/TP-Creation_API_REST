package com.quizapi.ApiQuiz.repository;

import com.quizapi.ApiQuiz.modele.Participation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
public class ParticipationRepository {
    public List<Participation> getParticipationsByUserId(Integer userId) {
        return null;
    }
}

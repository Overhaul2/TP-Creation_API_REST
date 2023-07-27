package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Participation;
import com.quizapi.ApiQuiz.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationRepository {
    private final com.quizapi.ApiQuiz.repository.ParticipationRepository participationRepository;

    public ParticipationRepository(com.quizapi.ApiQuiz.repository.ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public List<Participation> getUserParticipationByUserId(Long userId) {
        return participationRepository.getParticipationsByUserId(Math.toIntExact(userId));
    }
}
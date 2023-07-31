package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Participation;
import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("participationService")
public class ParticipationRepository {
    private com.quizapi.ApiQuiz.repository.ParticipationRepository participationRepository = null;
    private QuizRepository quizRepository = null;
    public ParticipationRepository(com.quizapi.ApiQuiz.repository.ParticipationRepository participationRepository, QuizRepository quizRepository) {
        this.participationRepository = participationRepository;
    }

   /* public List<Participation> getUserParticipationByUserId(Long userId) {
        return participationRepository.getParticipationsByUserId(Math.toIntExact(userId));*/


    @Autowired
    public ParticipationRepository(QuizRepository quizRepository){
        this.quizRepository= quizRepository;
    }
    public List<Quiz> getAllQuiz(){
        return quizRepository.findAll();
    }
}
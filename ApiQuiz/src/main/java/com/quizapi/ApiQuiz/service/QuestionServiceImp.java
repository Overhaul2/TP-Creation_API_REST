package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Question;
import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.repository.QuestionRepository;
import com.quizapi.ApiQuiz.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class QuestionServiceImp implements QuestionService{

    private final QuestionRepository questionRepository;
    private QuizRepository quizRepository;

    @Override
    public Question creer(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> lire() {
        return questionRepository.findAll();
    }

    @Override
    public Question modifier(Long idQ, Question question) {
        return questionRepository.findById(idQ)
                .map(p->{
                    p.setContent(question.getContent());
                    p.setQuiz(question.getQuiz());
                    return questionRepository.save(p);
                }).orElseThrow(() ->new RuntimeException("Question non trouvé!"));
    }

    @Override
    public String supprimer(Long idQ) {
        questionRepository.deleteById(idQ);
        return "Question supprimer";
    }

    @Override
    public List<Quiz> rechercherQuizByNom(String nom) {
        return quizRepository.findByNomContainingIgnoreCase(nom);
    }

}

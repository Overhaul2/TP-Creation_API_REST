package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Quiz;
import com.quizapi.ApiQuiz.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class QuizServiceImp implements QuizService{

    private final QuizRepository quizRepository;
    @Override
    public Quiz creer(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> lire() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz modifier(Long idQz, Quiz quiz) {
        return quizRepository.findById(idQz)
                .map(p-> {
                    p.setNom(quiz.getNom()) ;
                    p.setDomaine(quiz.getDomaine());
                    p.setQuestions(quiz.getQuestions());
                    p.setScores(quiz.getScores());
                    p.setUser(quiz.getUser());
                    return quizRepository.save(p);
                }).orElseThrow(() ->new RuntimeException("Quiz non trouvé!"));
    }

    @Override
    public String supprimer(Long idQz) {
        quizRepository.deleteById(idQz);
        return null;
    }
}

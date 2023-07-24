package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Score;
import com.quizapi.ApiQuiz.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScoreServiceIp implements ScoreService{

    private final ScoreRepository scoreRepository;

    @Override
    public Score creer(Long id, Long idQz, int point) {
        Score score = new Score();
        score.setId(id);
        score.setPoint(point);

        // Vous pouvez également rechercher le quiz par son ID et le définir ici, si nécessaire.
        // score.setQuiz(quizRepository.findById(idQz).orElse(null));

        return scoreRepository.save(score);
    }

    @Override
    public List<Score> lire() {
        return null;
    }
}

package com.quizapi.ApiQuiz.modele;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.List;
@AllArgsConstructor
@Data
public class MainQuiz {
    private String Name;
    private String Domaine;
    private List<QuestionApp> Questions;

}

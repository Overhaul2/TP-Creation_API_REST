package com.quizapi.ApiQuiz.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class QuestionApp{

    private String Question;
    private Map<Integer, String> Choix ;
    private Integer Reponse;
    private Long Point;
}

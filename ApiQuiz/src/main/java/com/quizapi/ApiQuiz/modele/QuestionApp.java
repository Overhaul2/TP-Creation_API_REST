package com.quizapi.ApiQuiz.modele;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class QuestionApp{
    @NotBlank
    private String Question;
    @NotEmpty
    private Map<Integer, String> Choix ;
    @NotBlank
    private Integer Reponse;
    @NotBlank
    private Long Point;
}

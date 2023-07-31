package com.quizapi.ApiQuiz.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class allQuiz {
    private Long id;
    private String nom;
    private String domaine;
}

package com.quizapi.ApiQuiz.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User_Update {
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
}

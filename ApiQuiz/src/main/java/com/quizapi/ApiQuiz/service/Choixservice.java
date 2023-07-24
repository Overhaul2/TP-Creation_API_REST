package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Choix;

import java.util.List;

public interface Choixservice {

    Choix creer(Choix choix);
    List<Choix> lire();

    Choix modifier(Long id,Choix choix);

    String supprimer(Long id);
}

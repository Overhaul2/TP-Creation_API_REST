package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Domaine;

import java.util.List;

public interface DomaineService {

    Domaine creer(Domaine domaine);

    List<Domaine> lire();

    Domaine modifier(int idDomaine, Domaine domaine);

    String supprimer(Long idDomaine);
}

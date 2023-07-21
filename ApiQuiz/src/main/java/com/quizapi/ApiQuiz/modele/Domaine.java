package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "domaine")
@NoArgsConstructor
@Setter
@Getter
public class Domaine {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Quiz> getQuizs() {
        return Quizs;
    }

    public void setQuizs(List<Quiz> quizs) {
        Quizs = quizs;
    }

    @OneToMany (mappedBy = "domaine")
    private List<Quiz> Quizs;
}

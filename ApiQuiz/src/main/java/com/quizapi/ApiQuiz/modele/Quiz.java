package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "quiz")
@Setter
@Getter
@AllArgsConstructor
public class Quiz {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
@Column(length = 50)
    private String nom;
@ManyToOne
    private Domaine domaine;
@OneToMany (mappedBy = "quiz")
    private List<Question> questions;
@OneToMany (mappedBy = "quiz")
private List<Score> scores;

    public Quiz() {

    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setId(long id) {
        this.id = id;
    }
}

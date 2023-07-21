package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "choix")
@Setter
@Getter
@AllArgsConstructor

public class Choix {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Boolean etat;
    private String contenu;

    @Override
    public String toString() {
        return "Choix{" +
                "etat=" + etat +
                ", contenu='" + contenu + '\'' +
                ", question=" + question +
                '}';
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @ManyToOne
    private Question question;
}

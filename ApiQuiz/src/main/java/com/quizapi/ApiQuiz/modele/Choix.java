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
    private Long id;
    private Boolean etat;
    private String contenu;

    @ManyToOne
    private Question question;

    @Override
    public String toString() {
        return "Choix{" +
                "etat=" + etat +
                ", contenu='" + contenu + '\'' +
                ", question=" + question +
                '}';
    }

}

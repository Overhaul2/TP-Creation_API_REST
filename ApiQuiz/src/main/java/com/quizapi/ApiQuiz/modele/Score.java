package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "scores")
@AllArgsConstructor
@Getter
@Setter
public class Score {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int id_user;
    private int point;
    @ManyToOne
    private Quiz quiz;

    @Override
    public String toString() {
        return "Score{" +
                "id_user=" + id_user +
                ", point=" + point +
                ", quiz=" + quiz +
                '}';
    }
    }

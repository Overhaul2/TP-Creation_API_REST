package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name = "scores")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int point;
    @ManyToOne
    private Quiz quiz;
    @ManyToMany
    private User user;

    @Override
    public String toString() {
        return "Score{" +
                "User=" + user +
                ", point=" + point +
                ", quiz=" + quiz +
                '}';
    }
    }

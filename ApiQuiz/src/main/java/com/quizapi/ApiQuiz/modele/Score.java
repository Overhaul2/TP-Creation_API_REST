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
    private Long id_user;
    @ManyToOne
    private Quiz quiz;

    }

package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table (name = "participation")
public class Participation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer score;

}

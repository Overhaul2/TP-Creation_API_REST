package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table (name = "question")
public class Question {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idQ;
    private String content;
    @ManyToOne
    private Quiz quiz;
    @OneToMany (mappedBy = "question")
    private List<Choix> choixes;

}

package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Long id;
    @NotBlank
    private String content;
    private Long point;
    @ManyToOne
    private Quiz quiz;
    @OneToMany (mappedBy = "question",orphanRemoval = true)
    private List<Choix> choixes;

}

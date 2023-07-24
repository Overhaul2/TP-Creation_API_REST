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
    private Long idDomaine;
    private String nom;
}

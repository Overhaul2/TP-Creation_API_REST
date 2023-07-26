package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "domaine")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Domaine {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nom;
}

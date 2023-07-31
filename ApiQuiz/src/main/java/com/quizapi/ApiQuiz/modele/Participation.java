package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "participation")
public class Participation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Long score;
    @ManyToOne
    private Quiz quiz;
    @ManyToOne
    private User user;

}

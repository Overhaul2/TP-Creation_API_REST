package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "quiz")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
@Column(length = 50)
    private String nom;

@ManyToOne
    private Domaine domaine;

@OneToMany (mappedBy = "quiz")
    private List<Question> questions;

@OneToMany (mappedBy = "quiz")
private List<Score> scores;

@ManyToOne
private User user;

@ManyToMany (mappedBy = "quizList")
    private List<User> users;

    public Long getId() {
        return idQz;
    }
}

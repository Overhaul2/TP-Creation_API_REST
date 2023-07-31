package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    private Long idQz;
@Column(length = 50)
    private String nom;
@ManyToOne
    private Domaine domaine;
@OneToMany (mappedBy = "quiz", orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();
@OneToMany (mappedBy = "quiz",orphanRemoval = true)
private List<Score> scores = new ArrayList<>();
@ManyToOne
private User user;
@ManyToMany (mappedBy = "quizList")
    private List<User> users;
}

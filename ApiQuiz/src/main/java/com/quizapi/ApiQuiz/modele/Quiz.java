package com.quizapi.ApiQuiz.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
@NotBlank
    private String nom;

@ManyToOne
private Domaine domaine;

@OneToMany(mappedBy = "quiz",orphanRemoval = true)
@JsonIgnore
private List<Participation> participationList;

@OneToMany (mappedBy = "quiz",orphanRemoval = true)
private List<Score> scores;

@ManyToOne
private User user;

/*@ManyToMany (mappedBy = "quizList")
    private List<User> users;

    public Long getId() {
        return id;
    }*/


}

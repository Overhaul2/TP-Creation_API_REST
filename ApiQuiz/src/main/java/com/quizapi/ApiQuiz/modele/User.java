package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private  String nom;
    private  String prenom;
    private  String email;
    private  String pseudo;
    private  String password;
    @OneToMany (mappedBy = "user")
    private List<Quiz> quizzes;
    @ManyToMany
    @JoinTable(
            name = "participation",
            inverseJoinColumns = @JoinColumn (name = "quiz_id")
    )
    private List<Quiz> quizList;

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

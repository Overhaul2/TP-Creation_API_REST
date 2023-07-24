package com.quizapi.ApiQuiz.modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private long id;

    @Column(nullable = false )
    @NotEmpty
    private  String nom;

    @Column(nullable = false)
    @NotEmpty
    private  String prenom;

    @Column(nullable = false,unique = true)
    private  String email;

    @Column(nullable = false,unique = true)
    @NotEmpty
    private  String pseudo;

    @Column(nullable = false)
    @NotEmpty
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

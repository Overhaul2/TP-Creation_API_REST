package com.quizapi.ApiQuiz.modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private long id;

    @Column(nullable = false )
    @NotBlank (message = "Le champ nom ne peut pas etre Vide")
    private  String nom;

    @Column(nullable = false)
    @NotBlank (message = "Le champ Personne ne peut pas etre Vide")
    private  String prenom;

    @Column(nullable = false,unique = true)
    @Email (message = "Votre email est incorrecte")
    private  String email;

    @Column(nullable = false,unique = true)
    @NotBlank (message = "Le Pseudo ne peut pas etre Vide")
    @Size (max = 10)
    private  String pseudo;


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
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.quizapi.ApiQuiz.modele;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.quizapi.ApiQuiz.service.Validator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
@JsonPropertyOrder(value = {"prenom","nom","pseudo","email"},alphabetic = true)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Le champ nom ne peut pas etre Vide")
    @Getter
    private String nom;

    @Column(nullable = false)
    @NotBlank(message = "Le champ Personne ne peut pas etre Vide")
    @Getter
    private String prenom;

    @Column(nullable = false, unique = true)
    @Email(message = "Votre email est incorrecte")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Le Pseudo ne peut pas etre Vide")
    @Getter
    private String pseudo;

    @OneToMany(mappedBy = "user",orphanRemoval = true)
    @JsonIgnore
    private List<Participation> participationList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Quiz> quizzes;
    /*/@ManyToMany
    @JsonIgnore
>>>>>>> 0c2d13f72aa234247526eb7d79520771ed3e225a
    @JoinTable(
            name = "participation",
            inverseJoinColumns = @JoinColumn(name = "quiz_id")
    )
    private List<Quiz> quizList;*/

    @Override
    @JsonIgnore
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", pseudo='" + pseudo + '\'' +
                '}';
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return null;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void setEmail(String email) {
        if (Validator.Email(email)){
        this.email = email;
        }else {
            this.email=null;
        }

    }
}


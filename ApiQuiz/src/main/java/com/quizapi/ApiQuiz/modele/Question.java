package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Setter
@Getter
@Table (name = "question")
public class Question {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    @ManyToOne
    private Quiz quiz;
    @OneToMany (mappedBy = "question")
    private List<Choix> choixes;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Choix> getChoixes() {
        return choixes;
    }

    public void setChoixes(List<Choix> choixes) {
        this.choixes = choixes;
    }

    public Question() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

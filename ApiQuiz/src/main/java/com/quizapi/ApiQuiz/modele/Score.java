package com.quizapi.ApiQuiz.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "scores")
@AllArgsConstructor
@Getter
@Setter
public class Score {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int id_user;
    private int point;
    @ManyToOne
    private Quiz quiz;

    @Override
    public String toString() {
        return "Score{" +
                "id_user=" + id_user +
                ", point=" + point +
                ", quiz=" + quiz +
                '}';
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}

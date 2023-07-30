package com.quizapi.ApiQuiz.modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonPropertyOrder({"Your_answer", "mainquiz"})
public class QuizAnswer {
    @JsonProperty("Your_answer")
    String Your_answer;
    @JsonProperty("Infos_Quiz")
    MainQuiz mainQuiz;
}

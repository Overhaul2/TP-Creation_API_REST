package com.quizapi.ApiQuiz.modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"Question", "Choix", "Point","Reponse"})
public class QuestionApp{
    @NotBlank
    @JsonProperty("Question")
    private String Question;
    @NotEmpty
    @JsonProperty("Choix")
    private Map<Integer, String> Choix ;
    @NotBlank
    @JsonProperty("Reponse")
    private Integer Reponse;
    @NotBlank
    @JsonProperty("Point")
    private Long Point;


}

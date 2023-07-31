package com.quizapi.ApiQuiz.modele;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({"Name", "Domaine", "Questions"})
public class MainQuiz {
    @NotBlank
    @JsonProperty("Name")
    private String Name;
    @NotBlank
    @JsonProperty("Domaine")
    private String Domaine;
    @NotEmpty
    @JsonProperty("Questions")
    private List<QuestionApp> Questions;


}

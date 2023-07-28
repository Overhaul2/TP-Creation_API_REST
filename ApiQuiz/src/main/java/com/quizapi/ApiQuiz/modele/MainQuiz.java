package com.quizapi.ApiQuiz.modele;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.List;
@AllArgsConstructor
@Data
public class MainQuiz {
    @NotBlank
    private String Name;
    @NotBlank
    private String Domaine;
    @NotEmpty
    private List<QuestionApp> Questions;

}

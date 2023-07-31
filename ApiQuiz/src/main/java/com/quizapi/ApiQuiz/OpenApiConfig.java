package com.quizapi.ApiQuiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Api Quiz")
                        .description("L'API Java Spring Boot pour la création de quiz fournira les fonctionnalités suivantes :\n" +
                                "\n" +
                                "Création de comptes utilisateurs : les utilisateurs pourront créer des comptes en fournissant un nom d'utilisateur, \n" +
                                "un mot de passe et une adresse e-mail.\n" +
                                "Gestion de quiz : les utilisateurs pourront créer, modifier et supprimer des quiz.\n "+
                                " Les quiz peuvent contenir des questions à choix unique, à choix multiple ou à réponse ouverte.\n" +
                                "Participation aux quiz : les utilisateurs pourront participer aux quiz en répondant aux questions.\n"+
                                " Les résultats des quiz seront enregistrés et les utilisateurs pourront consulter leurs scores.\n" +
                                "Classement : les utilisateurs pourront comparer leurs scores avec ceux des autres utilisateurs.\n" +
                                "L'API sera basée sur une architecture client-serveur, où les utilisateurs pourront accéder à l'application via une interface utilisateur conviviale sur le navigateur. L'application sera développée en Java Spring Boot, un framework Java open source qui facilite le développement d'applications web. Les données des utilisateurs, des quiz et des résultats seront stockées dans une base de données relationnelle telle que MySQL.")
                        .version("2.0"));
    }
}
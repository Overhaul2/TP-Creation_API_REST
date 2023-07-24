package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.ApiResponse;
import com.quizapi.ApiQuiz.modele.User;

import java.util.List;

public interface UserService {

    User creer(User user);

    List<User> lire();

    User modifie(Long idUser, User user);

    String Supprimer(Long User);

    ApiResponse login(String email, String password);
}

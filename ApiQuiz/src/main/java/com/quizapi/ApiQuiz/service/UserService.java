package com.quizapi.ApiQuiz.service;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository UserRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    public User saveUser(User user) {
        return UserRepository.save(user);
    }
    public Optional<User> finduser(Long id){
        return UserRepository.findById(id);
    }
    public String deletesuser(User user,Long id){
        UserRepository.deleteById(id);
        return "Deleted ";
    }

}

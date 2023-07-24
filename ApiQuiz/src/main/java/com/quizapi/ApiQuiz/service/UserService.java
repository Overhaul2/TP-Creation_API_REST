package com.quizapi.ApiQuiz.service;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.repository.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository UserRepository;
    public UserService(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    public ResponseEntity<String> saveUser(User user) {
        //on verifie ici que l'email est valid avec notre fonction dans le validator
        String mail = user.getEmail();
        String pseudo = user.getPseudo();
        if (!Validator.Email(mail)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse e-mail invalide !");
        }

        try {
             UserRepository.save(user) ;
             return ResponseEntity.ok("Donnee sauvegarder avec Succes et Voici votre Token que vous utiliserez pour vous connectez" +
                     JsonJwt.generateToken(user.getPrenom()));
         }
         catch (DataAccessException ex){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" Verifier que toutes vos champs sont rempli et que votre email est Correct");
         }
    }
    public Optional<User> finduser(Long id){
        return UserRepository.findById(id);
    }
    public String deletesuser(User user,Long id){
        UserRepository.deleteById(id);
        return "Deleted ";
    }
    public List<User> finduserByPseudo(String pseudo){
       return UserRepository.findByPseudo(pseudo);
    }

}

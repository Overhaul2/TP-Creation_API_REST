package com.quizapi.ApiQuiz.service;
import com.quizapi.ApiQuiz.Config.JwtService;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository UserRepository;
    private final JwtService jwtService;
    @NonNull HttpServletRequest request;


    public UserService(UserRepository userRepository, JwtService jwtService) {
        UserRepository = userRepository;
        this.jwtService = jwtService;
    }

    //
    public ResponseEntity<String> saveUser(User user) throws BindException {
        //on verifie ici que l'email est valid avec notre fonction dans le validator
        String mail = user.getEmail();
        String pseudo = user.getPseudo();
        if (!Validator.Email(mail)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse e-mail invalide !");
        }

        try {
             UserRepository.save(user) ;
             var JwtToken = jwtService.generatetoken(user);
             return ResponseEntity.ok("Voici votre Token\n" +
                     "!!!Attention!!! securisez le car c'est la seule maniere de vous connecter\n"+JwtToken);
         }
         catch (DataAccessException ex){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" Verifier que toutes vos champs sont rempli et que votre email est Correct");
              }

    }
    public Optional<User> finduser(Long id){
        return UserRepository.findById(id);
    }
    public Optional<User> finduser(){
        return UserRepository.findByEmail(UserApp.getEmail());
    }
    public String deletesuser(){
        UserRepository.deleteUserByEmail(UserApp.getEmail());
        return "Compte supprime avec succes";
    }
    public User modify(User user1){
            Optional<User> user2  = UserRepository.findByEmail(UserApp.getEmail());
             return user1;
    }

}

package com.quizapi.ApiQuiz.service;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.Config.JwtService;
import com.quizapi.ApiQuiz.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

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
        UserRepository.deleteByEmail(UserApp.getEmail());
        return "Compte supprime avec succes";
    }
    public ResponseEntity<String> modify(User_Update user1){
        User user2  = UserRepository.findUserByEmail(UserApp.getEmail());
        int i=0;
        if (user1.getNom() != null){
            user2.setNom(user1.getNom());
            i++;
        }
        if (user1.getPrenom() != null){
            user2.setPrenom(user1.getPrenom());
            i++;
        }

        if (user1.getPseudo() != null){
            user2.setPseudo(user1.getPseudo());
            i++;
        }
            if (user2.getEmail().equals(user1.getEmail())) {
                try {
                    UserRepository.save(user2);
                    return ResponseEntity.ok("Donnee Modifier avec succes Votre ancien Token est toujours valide prenez en soin.");
                } catch (DataAccessException ex) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" Verifier que toutes vos champs sont rempli" +
                            "et n'oublie pas le Pseudo  et l'email sont unique et que votre email est Correct");
                }

            } else {
                if (user1.getEmail()!=null){
                try {
                    user2.setEmail(user1.getEmail());
                    var JwtToken = jwtService.generatetoken(user2);
                    UserRepository.save(user2);
                    return ResponseEntity.ok("Donnee Modifier avec succes voici votre nouveau token\n" +
                            JwtToken);
                } catch (ConstraintViolationException ex) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" Un Probleme avec l'email");
                }

            }

        }
            if (i==0){
                return ResponseEntity.ok("Desole difficle de mettre a jour avec des donnee vide Veuillez reessayer");
            }
            UserRepository.save(user2);
            return ResponseEntity.ok("Donnee Modifier avec succes Votre ancien Token est toujours valide prenez en soin.");
    }

}



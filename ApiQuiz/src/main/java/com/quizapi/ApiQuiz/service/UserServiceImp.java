package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.ApiResponse;
import com.quizapi.ApiQuiz.modele.User;
import com.quizapi.ApiQuiz.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User modifie(Long idUser, User user) {
        return userRepository.findById(idUser)
                .map(p->{
                    p.setNom(user.getNom());
                    p.setPrenom(user.getPrenom());
                    p.setPrenom(user.getPseudo());
                    p.setEmail(user.getEmail());
                    p.setPassword(user.getPassword());
                    return userRepository.save(p);
                }).orElseThrow(() ->new RuntimeException("Utilisateur non trouvé!"));
    }

    @Override
    public String Supprimer(Long User) {
        userRepository.deleteById(User);
        return null;
    }

    //kuhsiygyfsg
    @Override
    public ApiResponse login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new RuntimeException("Nom d'utilisateur ou email incorrecte.");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Mot de passe incorrecte.");
        }
        return new ApiResponse(200, "Utilisateur connecté avec succès!", user) ;

    }
}

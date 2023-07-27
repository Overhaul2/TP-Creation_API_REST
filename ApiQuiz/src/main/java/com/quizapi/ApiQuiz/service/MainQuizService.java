package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.*;
import com.quizapi.ApiQuiz.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainQuizService {

public ResponseEntity<String> forQuiz(MainQuiz mainQuiz, DomaineRepository domaineRepository,
                                      QuizRepository quizRepository,
                                      UserRepository userRepository,
                                      QuestionRepository questionRepository,
                                      ChoiRepository choiRepository){

    //les attributs de main quiz
    String Quizname = mainQuiz.getName();
    String Domainename = mainQuiz.getDomaine();
    List<QuestionApp> questionApps = mainQuiz.getQuestions();
    
    //on recupere les domaine et le User
    Domaine domaine = domaineRepository.findDomaineByNomIgnoreCase(Domainename);
    User user = userRepository.findUserByEmail(UserApp.getEmail());

    //Verifions que le domaine existe
       if ( domaine == null){
           return  ResponseEntity.ok("Domaine Indisponible vous " +
                   "pouvez trouver l'ensemble des Domaine disponible a l'adresse \n" +
                   "http://localhost:8080/quiz/domaine");
       }else {
           //essayons de remplir le champ quiz avec les donnee


           if (user==null){return ResponseEntity.ok("Votre " +
                   "Quiz na puis etre sauvegarger");}
           else {
               //On a creer un quiz
               Quiz quiz = new Quiz();
               quiz.setNom(mainQuiz.getName());
               quiz.setDomaine(domaine);
               quiz.setUser(user);
               quizRepository.save(quiz);

               //Essayond de sauvegarder les question et les choix

               for (QuestionApp question: questionApps) {
                   //Nouveau  type question dans la database
                   Question question1 = new Question();

                   //Recuperation dans le Json
                   String content = question.getQuestion();
                   question1.setContent(content);

                   //le point de la question est defini
                   question1.setPoint(question.getPoint());

                   question1.setQuiz(quiz);

                   //Sauvegardons la question
                   questionRepository.save(question1);

                   //definissons les choix pour la question
                   if (!question.getChoix().isEmpty()){

                       for (int i = 0;i < 4; i++){
                           if (question.getChoix().containsKey(i)){
                               Choix choix = new Choix();
                               choix.setContenu( question.getChoix().get(i) );

                               //Si la valeur contenu dans la reponse de notre question est i alors l'etat du choix est true
                               if (i==question.getReponse()){
                                   choix.setEtat(true);
                               }
                               else {
                                   choix.setEtat(false);
                               }
                               choix.setQuestion(question1);
                               choiRepository.save(choix);
                           }
                           }


                   }

               }
               return  ResponseEntity.ok("Quiz enregistrer avec Succes");

           }

       }

}
}

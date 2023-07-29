package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.*;
import com.quizapi.ApiQuiz.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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

                       for (int i = 1;i < 5; i++){
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
public Object read(Long id, DomaineRepository domaineRepository,
                   QuizRepository quizRepository,
                   UserRepository userRepository,
                   QuestionRepository questionRepository,
                   ChoiRepository choiRepository){
    Quiz quiz = quizRepository.findQuizById(id);
    //verifions que l'utilisateur est le proprietaire du quiz
    if (quiz==null){
        return "Desole nous n'avons pas pu retrouver le quiz demander";
    }
    else {
        MainQuiz mainQuiz = new MainQuiz();
        //definissons le champ quiz name et consort

        if (userRepository.findUserByEmail(UserApp.getEmail())!=quiz.getUser()){
            return "Desole vous n'etes pas autorise a effectuer cette action";
        }
        else{
            //le nom
            mainQuiz.setName(quiz.getNom());

            //le domaine
            Domaine domaine = quiz.getDomaine();
            mainQuiz.setDomaine(domaine.getNom());

            //les question
            //connaitre d'abord le nombre de question d'une quiz 
            List<Question> questions = questionRepository.findAllByQuiz_Id(id);
            //questions contient toutes les questions de la quiz
            List<QuestionApp> questionAppList = new ArrayList<>();
            for (Question question: questions) {
                QuestionApp questionApp = new QuestionApp();

                questionApp.setQuestion(question.getContent());
                //essayons de recuperer les choix pour chaque question
                int i =0;
                questionApp.setPoint(question.getPoint());
                questionApp.setReponse(0);
                Map<Integer, String> choix1 = new HashMap<>();
                List<Choix> choixList = choiRepository.findAllByQuestion_Id(question.getId());
                for (Choix choix : choixList){
                    i++;
                    choix1.put(i, choix.getContenu());
                    if (choix.getEtat()==true){
                        questionApp.setReponse(i);
                    }
                    questionApp.setChoix(choix1);

                }

                questionAppList.add(questionApp);
            }
            mainQuiz.setQuestions(questionAppList);

            return mainQuiz;
            //fin
        }
    }

}
public Object update(Long id,MainQuiz mainQuiz,DomaineRepository domaineRepository,
                     QuizRepository quizRepository,
                     UserRepository userRepository,
                     QuestionRepository questionRepository,
                     ChoiRepository choiRepository){

           Quiz quiz = quizRepository.findQuizById(id);
           if (quiz==null){
               return "Desole nous n'avons pas pu retrouver le quiz demander";
           }else {
               if (userRepository.findUserByEmail(UserApp.getEmail())!=quiz.getUser()){
                   return "Desole vous n'etes pas autorise a effectuer cette action";
               }else {
                   //redefinition du quiz termine
                   quiz.setNom(mainQuiz.getName());
                   if (domaineRepository.findDomaineByNomIgnoreCase(mainQuiz.getDomaine())==null){
                       return "Domaine non disponible";
                   }
                   quiz.setDomaine(domaineRepository.findDomaineByNomIgnoreCase(mainQuiz.getDomaine()));
                   quizRepository.save(quiz);
                    //redefinition des questions maintenant
                   /* Comme lors de la mise a jour le nouveau quiz peut avoir avoir plus de question que l'ancien
                   *tout comme il peut en avoir moins donc nous nous devons de prendre ce cas en compte
                   * en verifiant si le nouveau a plus de question ensuite pour en ajouter de nouvelle lignes dans la *
                   * database ou s'il a moins de question on se doit de supprimer le restant */
                   List<Question> databaseQuestions = questionRepository.findAllByQuiz_Id(id);
                   List<QuestionApp> mainQuizQuestionApp = mainQuiz.getQuestions();

                   //Ici on recupere la taille la plus longe parmi les deux liste
                   int size;
                   if (databaseQuestions.size() >= mainQuizQuestionApp.size()){
                  size  = databaseQuestions.size();
                   }else {
                        size = mainQuizQuestionApp.size();
                   }
                   //Faisont une boucle de la plus longe des listes
                   for (int i = 0;i<size;i++){
                        if (i < databaseQuestions.size() && i< mainQuizQuestionApp.size()){
                            //on modifie le contenu de la question
                            databaseQuestions.get(i).setContent(mainQuizQuestionApp.get(i).getQuestion());
                            //on modifie le point
                            databaseQuestions.get(i).setPoint(mainQuizQuestionApp.get(i).getPoint());
                            //maintenant on s'attaque au choix
                            List<Choix> choixList = choiRepository.findAllByQuestion_Id(databaseQuestions.get(i).getId());
                            Map<Integer, String> choixes = mainQuizQuestionApp.get(i).getChoix();
                            int rep = mainQuizQuestionApp.get(i).getReponse();
                            for (int x = 1;x < 5;x++){
                                int z = x-1 ;
                                //on verifie aussi le nombre de choix si on augmente ou si on diminue
                                if (z < choixList.size()){
                                    if (choixes.containsKey(x)){
                                        choixList.get(z).setContenu(choixes.get(x));
                                        if (rep == x){
                                            choixList.get(z).setEtat(true);
                                        }else {
                                            choixList.get(z).setEtat(false);
                                        }

                                        choixList.get(z).setQuestion(questionRepository.findQuestionById(databaseQuestions.get(i).getId()));
                                        choiRepository.save(choixList.get(z));
                                    }
                                    else {
                                        choiRepository.deleteById(choixList.get(z).getId());
                                    }

                                }
                                else {
                                    Choix choix = new Choix();
                                    if (choixes.containsKey(x)){
                                        choix.setContenu(choixes.get(x));
                                        if (rep == x){
                                            choix.setEtat(true);
                                        }else {
                                            choix.setEtat(false);
                                        }
                                        choix.setQuestion(questionRepository.findQuestionById(databaseQuestions.get(i).getId()));
                                        choiRepository.save(choix);
                                    }
                                    databaseQuestions.get(i).setPoint(mainQuizQuestionApp.get(i).getPoint());
                                }

                            }
                            questionRepository.save(databaseQuestions.get(i));
                        }
                        //Dans ce cas c'est le nouveau quiz qui est le plus long alors on ajoute de nouvel question
                        else if (i >= databaseQuestions.size()) {
                            Question question = new Question();
                            //on definit le point et le content pour une question
                            question.setPoint(mainQuizQuestionApp.get(i).getPoint());
                            question.setContent(mainQuizQuestionApp.get(i).getQuestion());
                            //On definit le quiz
                            question.setQuiz(quiz);
                            //nouveau question creer
                            questionRepository.save(question);
                        }
                        //Dans ce cas ca veut dire que le nouvau quiz est court donc on efface le reste des question
                        else {
                                questionRepository.delete(databaseQuestions.get(i));
                        }
                   }

               }
               return "Quiz modifier avec succes";
           }
}
}

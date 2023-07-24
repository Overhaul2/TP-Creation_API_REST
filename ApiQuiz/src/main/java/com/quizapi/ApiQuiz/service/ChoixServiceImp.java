package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Choix;
import com.quizapi.ApiQuiz.repository.ChoiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChoixServiceImp implements Choixservice{

    private final ChoiRepository choiRepository;
    @Override
    public Choix creer(Choix choix) {
        return choiRepository.save(choix);
    }

    @Override
    public List<Choix> lire() {
        return choiRepository.findAll();
    }

    @Override
    public Choix modifier(Long id, Choix choix) {
        return choiRepository.findById(id)
                .map(p->{
                    p.setEtat(choix.getEtat());
                    p.setContenu(choix.getContenu());
                    return choiRepository.save(p);
                }).orElseThrow(() ->new RuntimeException("Choix non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        choiRepository.deleteById(id);
        return "Choix supprimé!";
    }
}

package com.quizapi.ApiQuiz.service;

import com.quizapi.ApiQuiz.modele.Domaine;
import com.quizapi.ApiQuiz.repository.DomaineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DomaineServiceImp implements DomaineService{

    private final DomaineRepository domaineRepository;
    @Override
    public Domaine creer(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    public List<Domaine> lire() {
        return domaineRepository.findAll();
    }

    @Override
    public Domaine modifier(int idDomaine, Domaine domaine) {
        return domaineRepository.findById((long) idDomaine)
                .map(p-> {
                    p.setNom(domaine.getNom());
                    return domaineRepository.save(p);
                }).orElseThrow(() ->new RuntimeException("Domaine non trouvé!"));
    }

    @Override
    public String supprimer(int idDomaine) {
        domaineRepository.deleteById(Long.valueOf(idDomaine));
        return "Domaine supprimer";
    }
}

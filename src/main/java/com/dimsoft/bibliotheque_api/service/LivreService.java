package com.dimsoft.bibliotheque_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dimsoft.bibliotheque_api.excetion.LivreIndisponibleException;
import com.dimsoft.bibliotheque_api.excetion.LivresNotFoundException;
import com.dimsoft.bibliotheque_api.model.Livre;
import com.dimsoft.bibliotheque_api.repository.LivreRepository;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> listerToutLesLivres(){
       return livreRepository.findAll();
    }

    public Livre trouverParId(Long id){
        return livreRepository.findById(id).
                    orElseThrow(() -> new LivresNotFoundException(id));
    }

    public Livre creerLivre(Livre livre){
        return livreRepository.save(livre);
    }

    public Livre emprunter(Long id){
        Livre livre = trouverParId(id);
        if(!livre.isDisponible()){
            throw new LivreIndisponibleException(id);
        }
        livre.setDisponible(false);
        return livreRepository.save(livre);
    }

    public void supprimerLivre(Long id){
        livreRepository.deleteById(id);
    }

}

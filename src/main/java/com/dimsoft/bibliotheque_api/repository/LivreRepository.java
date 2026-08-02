package com.dimsoft.bibliotheque_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dimsoft.bibliotheque_api.model.Livre;

public interface LivreRepository extends JpaRepository<Livre,Long>{

    List<Livre> findByAuteur(String auteur);

    List<Livre> findByDisponibleTrue();

}

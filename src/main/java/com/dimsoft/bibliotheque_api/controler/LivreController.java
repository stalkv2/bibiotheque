package com.dimsoft.bibliotheque_api.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dimsoft.bibliotheque_api.model.Livre;
import com.dimsoft.bibliotheque_api.service.LivreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreService livreService;
    public LivreController(LivreService livreService) {
    this.livreService = livreService;
    }
    @GetMapping
    public List<Livre> lister() {
    return livreService.listerToutLesLivres();
    }
    @GetMapping("/{id}")
    public Livre obtenir(@PathVariable Long id) {
    return livreService.trouverParId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livre creer(@Valid @RequestBody Livre livre) {
    return livreService.creerLivre(livre);
    }
    @PutMapping("/{id}/emprunter")
    public Livre emprunter(@PathVariable Long id) {
    return livreService.emprunter(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id) {
    livreService.supprimerLivre(id);
    }
}

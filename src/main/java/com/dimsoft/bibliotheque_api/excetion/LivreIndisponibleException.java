package com.dimsoft.bibliotheque_api.excetion;

public class LivreIndisponibleException extends RuntimeException{

    public LivreIndisponibleException(Long id) {
        super("Livre indisponible avec id"+id); 
    }

    

}

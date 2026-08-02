package com.dimsoft.bibliotheque_api.excetion;

public class LivresNotFoundException extends RuntimeException{

    public LivresNotFoundException(Long id) {
        super("Aucun livre trouvé avec lid"+id);
    }

    

}

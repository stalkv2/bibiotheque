package com.dimsoft.bibliotheque_api.excetion;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestionnaireErreurs {


    @ExceptionHandler(LivresNotFoundException.class)
    public ResponseEntity<Object> gererLivreNotFound(LivreIndisponibleException e){
        Map<String,Object> corps = Map.of(
            "horodatage",Instant.now().toString(),
            "statut",HttpStatus.NOT_FOUND.value(),
            "message",e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corps);
    }

    @ExceptionHandler(LivreIndisponibleException.class)
    public ResponseEntity<Object> gererLivreIndisponible(LivreIndisponibleException e){
        Map<String,Object> corps = Map.of(
            "horodatage",Instant.now().toString(),
            "statut",HttpStatus.NOT_FOUND.value(),
            "message",e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corps);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> gererValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erreurs = ex.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(
        fe -> fe.getField(),
        fe -> fe.getDefaultMessage(),
        (a, b) -> a
        ));
        return ResponseEntity.badRequest().body(erreurs);
    }


}

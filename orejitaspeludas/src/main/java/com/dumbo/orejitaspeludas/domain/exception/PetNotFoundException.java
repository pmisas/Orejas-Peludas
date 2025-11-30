package com.dumbo.orejitaspeludas.domain.exception;

import java.util.UUID;

import com.dumbo.orejitaspeludas.domain.model.Pet;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(UUID petId) {
        super("Pet not found with id: " + petId);
    }
    
}

package com.dumbo.orejitaspeludas.infraestructure.rest;

import com.dumbo.orejitaspeludas.domain.model.Pet;
import com.dumbo.orejitaspeludas.infraestructure.rest.dto.PetResponse;

public final class PetRestMapper {
    
    private PetRestMapper() {
        // Utility class
    }

    public static PetResponse toResponse(Pet pet){
        return new PetResponse(
            pet.getId(), 
            pet.getName(), 
            pet.getBithDate(), 
            pet.getOwnerName(), 
            pet.getOwnerPhone(), 
            pet.getWeightKg(), 
            pet.getBreed(), 
            pet.getSpecies());
    }
}

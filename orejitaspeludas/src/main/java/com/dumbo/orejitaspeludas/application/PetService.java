package com.dumbo.orejitaspeludas.application;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.dumbo.orejitaspeludas.domain.model.Pet;
import com.dumbo.orejitaspeludas.domain.model.Species;

public interface PetService {
    
    Pet createPet(
            String name,
            LocalDate birthDate,
            String ownerName,
            String ownerPhone,
            double weightKg,
            String breed,
            Species species
    );

    Pet getById(UUID id);

    List<Pet> getAllPets();

    Pet updatePet(
            UUID id,
            String name,
            LocalDate birthDate,
            String ownerName,
            String ownerPhone,
            double weightKg,
            String breed,
            Species species
    );

    void delete(UUID id);
}

package com.dumbo.orejitaspeludas.infraestructure.rest.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.dumbo.orejitaspeludas.domain.model.Species;


public class PetResponse {

    private final UUID id;
    private final String name;
    private final LocalDate birthDate;
    private final String ownerName;
    private final String ownerPhone;
    private final double weightKg;
    private final String breed;
    private final Species species;


    public PetResponse(
                UUID id,
                String name,
                LocalDate birthDate,
                String ownerName,
                String ownerPhone,
                double weightKg,
                String breed,
                Species species) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.weightKg = weightKg;
        this.breed = breed;
        this.species = species;
    }

    public UUID getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Species getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }
}

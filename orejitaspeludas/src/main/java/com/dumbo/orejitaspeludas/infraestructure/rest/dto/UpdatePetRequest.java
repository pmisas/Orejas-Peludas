package com.dumbo.orejitaspeludas.infraestructure.rest.dto;

import java.time.LocalDate;

import com.dumbo.orejitaspeludas.domain.model.Species;

import jakarta.validation.constraints.*;

public class UpdatePetRequest {
    
    @NotBlank
    private String name;

    @NotNull
    @PastOrPresent
    private LocalDate birthDate;
    
    @NotBlank
    private String ownerName;
    
    @NotBlank
    private String ownerPhone;
    
    @Positive
    private double weightKg;
    
    @NotBlank
    private String breed;
    
    @NotNull
    private Species species;


    protected UpdatePetRequest() {
        
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

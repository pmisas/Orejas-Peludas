package com.dumbo.orejitaspeludas.domain.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Pet {

    private final UUID id;
    private final String name;
    private final LocalDate birthDate;
    private final String ownerName;
    private final String ownerPhone;
    private final double weightKg;
    private final String breed;
    private final Species species;

    private Pet(UUID id,
                String name, 
                LocalDate birthDate, 
                String ownerName,
                String ownerPhone,
                double weightKg,
                String breed,
                Species species){
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.birthDate = Objects.requireNonNull(birthDate);
        this.ownerName = Objects.requireNonNull(ownerName);
        this.ownerPhone = Objects.requireNonNull(ownerPhone);
        this.breed = Objects.requireNonNull(breed);
        this.species = Objects.requireNonNull(species);

        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
        this.weightKg = weightKg;
    }

    public static Pet createPet(String name, 
                                LocalDate birthDate, 
                                String ownerName,
                                String ownerPhone,
                                double weightKg,
                                String breed,
                                Species species){
        return new Pet(
                UUID.randomUUID(), 
                name, birthDate, 
                ownerName, 
                ownerPhone, 
                weightKg, 
                breed, 
                species);
    }

    public Pet updaPet(String name, 
                        LocalDate birthDate, 
                        String ownerName,
                        String ownerPhone,
                        double weightKg,
                        String breed,
                        Species species){
        return new Pet(
                this.id, 
                name, 
                birthDate, 
                ownerName, 
                ownerPhone, 
                weightKg, 
                breed, 
                species);
    }

    public static Pet recreatePet(
                        UUID id,
                        String name, 
                        LocalDate birthDate, 
                        String ownerName,
                        String ownerPhone,
                        double weightKg,
                        String breed,
                        Species species){
        return new Pet(
                id,
                name,
                birthDate, 
                ownerName, 
                ownerPhone, 
                weightKg, 
                breed, 
                species
        );
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getBithDate(){
        return this.birthDate;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public String getOwnerPhone(){
        return this.ownerPhone;
    }

    public String getBreed(){
        return this.breed;
    }

    public Species getSpecie(){
        return this.species;
    }

    @Override 
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return java.util.Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(id);
    }

}

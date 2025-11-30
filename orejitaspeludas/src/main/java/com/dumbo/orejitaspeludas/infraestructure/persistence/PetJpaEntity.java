package com.dumbo.orejitaspeludas.infraestructure.persistence;

import java.time.LocalDate;
import java.util.UUID;

import com.dumbo.orejitaspeludas.domain.model.Species;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class PetJpaEntity {
    
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "ownerName", nullable = false)
    private  String ownerName;

    @Column(name = "ownerPhone", nullable = false)
    private String ownerPhone;

    @Column(name = "weightKg", nullable = false)
    private double weightKg;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "species", nullable = false)
    private Species species;

    public PetJpaEntity(
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

    protected PetJpaEntity(){

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

    public double getWeightKg(){
        return this.weightKg;
    }

    public Species getSpecies(){
        return this.species;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    
}

package com.dumbo.orejitaspeludas.application;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dumbo.orejitaspeludas.domain.exception.PetNotFoundException;
import com.dumbo.orejitaspeludas.domain.model.Pet;
import com.dumbo.orejitaspeludas.domain.model.Species;
import com.dumbo.orejitaspeludas.domain.port.PetRepository;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository){
        this.petRepository = petRepository;
    }
    
    @Override
    public Pet createPet(
                    String name,
                    LocalDate birthDate,
                    String ownerName,
                    String ownerPhone,
                    double weightKg,
                    String breed,
                    Species species) {      
        Pet pet = Pet.createPet(
        name,
        birthDate,
        ownerName,
        ownerPhone,
        weightKg,
        breed,
        species
        );

        return petRepository.save(pet);
    }

    @Override
    public Pet getById(UUID id){
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    @Override
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    @Override
    public Pet updatePet(
            UUID id,
            String name,
            LocalDate birDate,
            String ownerName,
            String ownerPhone,
            double weightKg,
            String breed,
            Species species
    ){
        Pet existing = getById(id);

        Pet updated = existing.updatePet(  
            name,
            birDate,
            ownerName,
            ownerPhone,
            weightKg,
            breed,
            species
        );

        return petRepository.save(updated);
    }

    @Override
    public void delete(UUID id){
        if (!petRepository.existById(id)){
            throw new  PetNotFoundException(id);
        }
        petRepository.deleteById(id);
    }
}

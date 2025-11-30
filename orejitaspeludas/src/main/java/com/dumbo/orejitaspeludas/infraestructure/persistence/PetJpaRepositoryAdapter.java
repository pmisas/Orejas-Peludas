package com.dumbo.orejitaspeludas.infraestructure.persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.dumbo.orejitaspeludas.domain.model.Pet;
import com.dumbo.orejitaspeludas.domain.model.Species;
import com.dumbo.orejitaspeludas.domain.port.PetRepository;

@Repository
public class PetJpaRepositoryAdapter implements PetRepository {

    private final SpringDataPetJpaRepository jpaRepository;

    public PetJpaRepositoryAdapter(SpringDataPetJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Pet save(Pet pet){
        PetJpaEntity entity = toEntity(pet);
        PetJpaEntity saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    public Optional<Pet> findById(UUID id){
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Pet> findAll(){
        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void delete(UUID id){
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existById(UUID id){
        return jpaRepository.existsById(id);
    }

    private PetJpaEntity toEntity(Pet pet){
        return new PetJpaEntity(
            pet.getId(),
            pet.getName(),
            pet.getBithDate(),
            pet.getOwnerName(),
            pet.getOwnerPhone(),
            pet.getWeightKg(),
            pet.getBreed(),
            pet.getSpecies()
        );
    }

    private Pet toDomain(PetJpaEntity entity){
        return Pet.recreatePet(
            entity.getId(),
            entity.getName(),
            entity.getBithDate(),
            entity.getOwnerName(),
            entity.getOwnerPhone(),
            entity.getWeightKg(),
            entity.getBreed(),
            entity.getSpecies()
        );
    }
    
}

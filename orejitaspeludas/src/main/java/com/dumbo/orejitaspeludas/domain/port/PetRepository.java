package com.dumbo.orejitaspeludas.domain.port;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dumbo.orejitaspeludas.domain.model.Pet;

public interface PetRepository {
    Pet save(Pet pet);
    Optional<Pet> findById(UUID id);
    List<Pet> findAll();
    void deleteById(UUID id);
    boolean existById(UUID id);
    
}

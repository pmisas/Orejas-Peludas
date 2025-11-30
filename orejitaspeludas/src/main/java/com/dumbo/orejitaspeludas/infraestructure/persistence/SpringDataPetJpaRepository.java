package com.dumbo.orejitaspeludas.infraestructure.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPetJpaRepository extends JpaRepository<PetJpaEntity, UUID> {
    
}

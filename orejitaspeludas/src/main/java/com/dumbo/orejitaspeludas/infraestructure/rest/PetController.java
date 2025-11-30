package com.dumbo.orejitaspeludas.infraestructure.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dumbo.orejitaspeludas.application.PetService;
import com.dumbo.orejitaspeludas.domain.model.Pet;
import com.dumbo.orejitaspeludas.infraestructure.rest.dto.CreatePetRequest;
import com.dumbo.orejitaspeludas.infraestructure.rest.dto.PetResponse;
import com.dumbo.orejitaspeludas.infraestructure.rest.dto.UpdatePetRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController{
    
    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetResponse createPet(@Valid @RequestBody CreatePetRequest request){
        Pet pet = petService.createPet(
            request.getName(),
            request.getBirthDate(), 
            request.getOwnerName(), 
            request.getOwnerPhone(), 
            request.getWeightKg(), 
            request.getBreed(), 
            request.getSpecies()
        );
        
        return PetRestMapper.toResponse(pet);
    }

    @GetMapping("/{id}")
    public PetResponse getPetById(@PathVariable("id") UUID id){
        Pet pet = petService.getById(id);
        return PetRestMapper.toResponse(pet);
    }

    @GetMapping
    public List<PetResponse> getAllPets(){
        return petService.getAllPets().stream()
                .map(PetRestMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public PetResponse updatePet(@PathVariable("id") UUID id, @Valid @RequestBody UpdatePetRequest request) {
        Pet pet = petService.updatePet(
            id,
            request.getName(),
            request.getBirthDate(), 
            request.getOwnerName(), 
            request.getOwnerPhone(), 
            request.getWeightKg(), 
            request.getBreed(), 
            request.getSpecies()
        );

        return PetRestMapper.toResponse(pet);
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id){
        petService.delete(id);
    }
}

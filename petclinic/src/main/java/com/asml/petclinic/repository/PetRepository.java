package com.asml.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asml.petclinic.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{

}

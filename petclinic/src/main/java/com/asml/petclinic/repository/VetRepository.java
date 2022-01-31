package com.asml.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;

public interface VetRepository extends JpaRepository<Vet, Integer>{

}

package com.asml.petclinic.service;

import java.util.List;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Pet;

public interface PetService {

	
    List<Pet> get();
	List<Pet> findByType(String type);
    List<Pet> findByAge(Integer age);
	public void add(Pet pet);

}


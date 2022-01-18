package com.asml.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Pet;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.service.PetService;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	PetDaoImpl petDaoImpl;

	@Override
	public List<Pet> get() {
		return petDaoImpl.getAll();
	}

	@Override
	public List<Pet> findByType(String type) {
 
		return petDaoImpl.findByBreed(type);
	}

	@Override
	public List<Pet> findByAge(Integer age) {
		return petDaoImpl.findByAges(age);
	}
	
	@Override
	public void add(Pet pet) {
          
		petDaoImpl.add(pet);
	}


}

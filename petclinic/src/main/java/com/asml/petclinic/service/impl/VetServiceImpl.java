package com.asml.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.repository.impl.VetDaoImpl;
import com.asml.petclinic.service.PetService;
import com.asml.petclinic.service.VetService;

@Service
public class VetServiceImpl implements VetService {
	
	@Autowired
	VetDaoImpl vetDaoImpl;

	@Override
	public List<Vet> get() {
		return vetDaoImpl.getAll();
	}

	@Override
	public List<Vet> findByName(String name) {
 
		return vetDaoImpl.findByVetName(name);
	}

	@Override
	public List<Vet> findByLikeName(String name) {
		return vetDaoImpl.findByVetNameLike(name);
	}
	
	@Override
	public void add(Vet e) {
          
		vetDaoImpl.add(e);
	}

}

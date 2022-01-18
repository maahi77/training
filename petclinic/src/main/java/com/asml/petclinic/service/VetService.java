package com.asml.petclinic.service;

import java.util.List;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Vet;

public interface VetService {
	
    List<Vet> get();
	List<Vet> findByName(String name);
	List<Vet> findByLikeName(String name);
	public void add(Vet vet);



}

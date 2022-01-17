package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Owner;
import com.asml.petclinic.model.Pet;
import com.asml.petclinic.repository.impl.OwnerDaoImpl;
import com.asml.petclinic.repository.impl.PetDaoImpl;

@RestController
public class PetController {
	
	@Autowired
	PetDaoImpl petDaoImpl;
    @GetMapping("/pet")
    public List<Pet> getAllAppointments ()
    {
        return petDaoImpl.getAll();
    }
    
    @GetMapping("/pet/{type}")
    public List<Pet> getByDays ( @PathVariable(value = "type" )String type)
    {
        return petDaoImpl.findByBreed(type);
    }

 
    @GetMapping("/petbetween")
    public List<Pet> getAge( Integer age){
    	return petDaoImpl.findByAges(age);
    }

}

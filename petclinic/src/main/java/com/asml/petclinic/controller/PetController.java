package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;
import com.asml.petclinic.model.Pet;
import com.asml.petclinic.repository.impl.OwnerDaoImpl;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.service.PetService;

@RestController
public class PetController {
	
	@Autowired
	PetService petService;
	
    @GetMapping("/pet")
    public List<Pet> getAllAppointments ()
    {
        return petService.get();
    }
    
    @GetMapping("/pet/{type}")
    public List<Pet> getByDays ( @PathVariable(value = "type" )String type)
    {
        return petService.findByType(type);
    }

 
    @GetMapping("/petbetween")
    public List<Pet> getAge( Integer age){
    	return petService.findByAge(age);
    }
     
    @PostMapping("/pets")
    public void adds(@RequestBody Pet pet) {
    	
    	 petService.add(pet);
    }

}

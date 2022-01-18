package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.repository.impl.VetDaoImpl;
import com.asml.petclinic.service.VetService;
@RestController
public class VetController {
	
	@Autowired
  VetService vetService;   
@GetMapping("/vet")
    public List<Vet> getAllAppointments ()
    {
        return vetService.get();
    }
    
    @GetMapping("/vet/{name}")
    public List<Vet> getByDays (@PathVariable(value = "name") String name)
    {
        return vetService.findByName(name);
    }

    @GetMapping("/vetlike")
    public List<Vet> getByLikeName ( String name)
    {
        return vetService.findByLikeName(name);
    }
    
    @PostMapping("/vets")
    public void add(@RequestBody Vet vet) {
    	
    	 vetService.add(vet);
    }


}

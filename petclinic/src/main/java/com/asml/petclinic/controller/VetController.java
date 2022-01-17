package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.repository.impl.VetDaoImpl;
@RestController
public class VetController {
	
	@Autowired
	VetDaoImpl vetDaoImpl;
    @GetMapping("/vet")
    public List<Vet> getAllAppointments ()
    {
        return vetDaoImpl.getAll();
    }
    
    @GetMapping("/vet/{name}")
    public List<Vet> getByDays (@PathVariable(value = "name") String name)
    {
        return vetDaoImpl.findByVetName(name);
    }

    @GetMapping("/vetlike")
    public List<Vet> getByLikeName ( String name)
    {
        return vetDaoImpl.findByVetNameLike(name);
    }


}

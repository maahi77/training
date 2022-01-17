package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;
import com.asml.petclinic.repository.impl.OwnerDaoImpl;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerDaoImpl ownerDaoImpl;
    @GetMapping("/owner")
    public List<Owner> getAllAppointments ()
    {
    	
        return ownerDaoImpl.getAll();
    }
    
    @GetMapping("/owner/{owner_name}")
    public List<Owner> getByDays (@PathVariable(value="owner_name") String owner_name)
    {
        return ownerDaoImpl.getByName(owner_name);
    }
 
    
    @GetMapping("/owner/{owner_name}/{num}")
    public List<Owner> getByNumAndName(@PathVariable(value = "owner_name") String owner_name,@PathVariable(value = "num") Integer num){
    	return ownerDaoImpl.getByNameAndNum(owner_name, num);
    }
  
}

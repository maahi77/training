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
import com.asml.petclinic.repository.impl.OwnerDaoImpl;
import com.asml.petclinic.service.OwnerService;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
    @GetMapping("/owner")
    public List<Owner> getAllAppointments ()
    {
    	
        return ownerService.getOwners();
    }
    
    @GetMapping("/owner/{owner_name}")
    public List<Owner> getByDays (@PathVariable(value="owner_name") String owner_name)
    {
        return ownerService.findByName(owner_name);
    }
 
    
    @GetMapping("/owner/{owner_name}/{num}")
    public List<Owner> getByNumAndName(@PathVariable(value = "owner_name") String owner_name,@PathVariable(value = "num") Integer num){
    	return ownerService.findByNameAndNum(owner_name, num);
    }
    @PostMapping("/owners")
    public void add(@RequestBody Owner owner) {
    	
    	 ownerService.add(owner);
    }

  
}

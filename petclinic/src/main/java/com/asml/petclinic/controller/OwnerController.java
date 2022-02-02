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
    @GetMapping("/allowners")
    public List<Owner> getAllAppointments ()
    {
    	
        return ownerService.getOwners();
    }
    
    @GetMapping("/owner/{ownername}")
    public List<Owner> getByDays (@PathVariable(value="ownername") String ownername)
    {
        return ownerService.findByName(ownername);
    }
 
    
    @GetMapping("/owner/{ownername}/{num}")
    public List<Owner> getByNumAndName(@PathVariable(value = "ownername") String ownername,@PathVariable(value = "num") Integer num){
    	return ownerService.findByNameAndNum(ownername, num);
    }
    @PostMapping("/owners/add")
    public void add(@RequestBody Owner owner) {
    	
    	 ownerService.add(owner);
    }

  
}

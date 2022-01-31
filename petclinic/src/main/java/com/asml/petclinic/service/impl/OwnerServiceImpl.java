package com.asml.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;
import com.asml.petclinic.repository.impl.AppointmentDaoImpl;
import com.asml.petclinic.repository.impl.OwnerDaoImpl;
import com.asml.petclinic.service.AppointmentService;
import com.asml.petclinic.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	OwnerDaoImpl ownerDaoImpl;

	@Override
	public List<Owner> getOwners() {
		return ownerDaoImpl.getAll();
	}

	@Override
	public List<Owner> findByName(String owner_name) {
		// TODO Auto-generated method stub
		return ownerDaoImpl.getByName(owner_name);
	}

	@Override
	public List<Owner> findByNameAndNum(String owner_name, Integer num) {
		return ownerDaoImpl.getByNameAndNum(owner_name,num);
	}

	@Override
	public void add(Owner owner) {
          
		ownerDaoImpl.add(owner);
	}

	  

}

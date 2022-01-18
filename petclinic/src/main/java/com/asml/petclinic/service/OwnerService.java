package com.asml.petclinic.service;

import java.util.List;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;

public interface OwnerService {
    List<Owner> getOwners();
	List<Owner> findByName(String owner_name);
    List<Owner> findByNameAndNum(String owner_name, Integer num);
	public void add(Owner owner);

}

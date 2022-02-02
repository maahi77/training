package com.asml.petclinic.service;

import java.util.List;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;

public interface OwnerService {
    List<Owner> getOwners();
	List<Owner> findByName(String ownername);
    List<Owner> findByNameAndNum(String ownername, Integer num);
	public void add(Owner e);

}

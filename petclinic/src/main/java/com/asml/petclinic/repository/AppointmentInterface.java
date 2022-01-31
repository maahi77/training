package com.asml.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asml.petclinic.model.Appointment;
@Repository
public interface AppointmentInterface extends CrudRepository<Appointment, Integer> {
	
	

}

package com.asml.petclinic.service;

import java.util.List;

import com.asml.petclinic.model.Appointment;

public interface AppointmentService {
	
    List<Appointment> get();
	List<Appointment> findByDay(Integer day);
    List<Appointment> findByTime(Integer stime);
	public void add(Appointment appointment);

}

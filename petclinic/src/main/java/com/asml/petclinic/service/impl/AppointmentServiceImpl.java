package com.asml.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.repository.impl.AppointmentDaoImpl;
import com.asml.petclinic.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDaoImpl appointmentDaoImpl;

	@Override
	public List<Appointment> get() {
		return appointmentDaoImpl.getAll();
	}


	@Override
	public List<Appointment> findByDay(Integer day) {
		return appointmentDaoImpl.getByDay(day);
	}


	@Override
	public List<Appointment> findByTime(Integer stime) {
		return appointmentDaoImpl.findByStime(stime);
	}


	@Override
	public void add(Appointment appointment) {
          
		appointmentDaoImpl.add(appointment);
	}



}

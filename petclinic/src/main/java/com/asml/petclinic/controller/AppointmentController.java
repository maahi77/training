package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.repository.impl.AppointmentDaoImpl;
@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentDaoImpl appointmentDaoImpl;
    @GetMapping("/appointment")
    public List<Appointment> getAllAppointments ()
    {
    	
        return appointmentDaoImpl.getAll();
    }
    
    @GetMapping("/appointment/{day}")
    public List<Appointment> getByDays (@PathVariable(value="day") Integer day)
    {
        return appointmentDaoImpl.getByDay(day);
    }

      @GetMapping("/between")
      public List<Appointment> getByStime(Integer stime)
      {
    	  return appointmentDaoImpl.findByStime(stime);
      }
    
    
      
}

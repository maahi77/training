package com.asml.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.service.AppointmentService;
@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService ;
    @GetMapping("/allappointments")
    public List<Appointment> getAllAppointments ()
    {
    	
        return appointmentService.get();
    }
    
    @GetMapping("/appointment/{day}")
    public List<Appointment> getByDays (@PathVariable(value="day") Integer day)
    {
        return appointmentService.findByDay(day);
    }

      @GetMapping("/appointmentsbetween")
      public List<Appointment> getByStime(Integer stime)
      {
    	  return appointmentService.findByTime(stime);
      }
    
    @PostMapping("/appointments/add")
    public void add(@RequestBody Appointment appointment) {
    	
    	 appointmentService.add(appointment);
    }
      
}

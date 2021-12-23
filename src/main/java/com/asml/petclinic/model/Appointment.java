package com.asml.petclinic.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private BigDecimal price;
	private Integer date;
	private LocalTime stime;

}

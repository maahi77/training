package com.asml.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
	
	@Id
	private String name;
	private Long num;
	private String village;
	private String state;
	private Long pincode;
	

}

package com.asml.petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	private Long num;
	private String village;
	private String state;
	private Long pincode;
	@OneToMany(cascade =CascadeType.ALL )
	@JoinColumn(name = "f_name",referencedColumnName = "name")
	List<Pet> pets=new ArrayList<>();
	
	@OneToMany(cascade =CascadeType.ALL )
	@JoinColumn(name = "f_name",referencedColumnName = "name")
	List<Appointment> appointment=new ArrayList<>();

	
	
	

}

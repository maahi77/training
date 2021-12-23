package com.asml.petclinic.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long phnum;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "vet_pet",joinColumns = { @JoinColumn(name="vet_id")},
	inverseJoinColumns = { @JoinColumn(name="pet_id")}
	
			)
	private Set<Pet> pets=new HashSet<>();
	
	@OneToMany(cascade =CascadeType.ALL )
	@JoinColumn(name = "f_id",referencedColumnName = "id")
	List<Appointment> appointments=new ArrayList<>();


	

}

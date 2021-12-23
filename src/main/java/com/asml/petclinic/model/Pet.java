package com.asml.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	private String type;
	private int age;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "pets")
	private Set<Vet> vets=new HashSet<>();


}

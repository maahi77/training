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
public class Vet {
	
	@Id
	private Long id;
	private String name;
	private Long phnum;
	

}

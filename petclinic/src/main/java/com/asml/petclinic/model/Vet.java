package com.asml.petclinic.model;

import java.util.HashSet;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data

@ToString
@NamedQuery(name="Vet.findall",query = "select e from Vet e ")
@NamedQuery(name="Vet.findbyvetname",query = "select e from Vet e where e.name=:name")
@Table(name = "Vets")
public class Vet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vet_id;
	private String name;
	private Long phnum;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "vets_pets",joinColumns = { @JoinColumn(name="vets_id")},
	inverseJoinColumns = { @JoinColumn(name="pets_id")}
	
			)
	private Set<Pet> pets=new HashSet<>();
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER )
	private Set<Appointment> appointments;

	public Vet(Long vet_id, String name, Long phnum) {
		super();
		this.vet_id = vet_id;
		this.name = name;
		this.phnum = phnum;
	}

	public Long getVet_id() {
		return vet_id;
	}

	public void setVet_id(Long vet_id) {
		this.vet_id = vet_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhnum() {
		return phnum;
	}

	public void setPhnum(Long phnum) {
		this.phnum = phnum;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}


	

}


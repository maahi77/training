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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/* 
 * @author bindu
 * 
 * Vet class contains details 
 * about vets
 *
 */

@Entity
@NamedQueries({@NamedQuery(name="Vet.findall",query = "select e from Vet e "),
@NamedQuery(name="Vet.findbyvetname",query = "select e from Vet e where e.name=:name")
})
@Table(name = "Vets")
public class Vet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vetid;
	private String name;
	private Long phnum;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "vets_pets",joinColumns = { @JoinColumn(name="vets_id")},
	inverseJoinColumns = { @JoinColumn(name="pets_id")}
	
			)
	private Set<Pet> pets=new HashSet<>();
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "vet" )
	private Set<Appointment> appointments=new HashSet<>();

	
	public Vet() {
		super();
	}

	public Vet(Long vetid, String name, Long phnum) {
		super();
		this.vetid = vetid;
		this.name = name;
		this.phnum = phnum;
	}

	public Long getVetid() {
		return vetid;
	}

	public void setVet_id(Long vetid) {
		this.vetid = vetid;
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

	@Override
	public String toString() {
		return "Vet [vetid=" + vetid + ", name=" + name + ", phnum=" + phnum + ", pets=" + pets + ", appointments="
				+ appointments + "]";
	}


	

}


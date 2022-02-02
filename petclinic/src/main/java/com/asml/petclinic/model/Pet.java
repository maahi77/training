package com.asml.petclinic.model;

import java.util.HashSet;
/* 
 * @author bindu
 * 
 * Pet class contains details 
 * about pets
 *
 */

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries ({@NamedQuery(name="Pet.findall",query = "select e from Pet e "),
@NamedQuery(name="Pet.findbytype",query = "select e from Pet e where e.type=:type")
})
@Table(name = "Pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petid;
	private String name;
	private String type;
	private int age;
	
	
	
	public Pet() {
		super();
	}
	public Pet(Integer petid,String name, String type, int age) {
		super();
		this.petid=petid;
		this.name = name;
		this.type = type;
		this.age = age;
	}
	@ManyToOne
	@JoinColumn(name = "ownername",referencedColumnName = "ownername")
	private Owner owner;
	@ManyToMany(mappedBy = "pets")
	private Set<Vet> vets=new HashSet<>();



	public Integer getPetid() {
		return petid;
	}
	public void setPet_id(Integer petid) {
		this.petid = petid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Set<Vet> getVets() {
		return vets;
	}
	public void setVets(Set<Vet> vets) {
		this.vets = vets;
	}
	@Override
	public String toString() {
		return "Pet [petid=" + petid + ", name=" + name + ", type=" + type + ", age=" + age + ", owner=" + owner
				+ ", vets=" + vets + "]";
	}

	

}

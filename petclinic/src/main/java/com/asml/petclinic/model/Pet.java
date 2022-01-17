package com.asml.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@NamedQuery(name="Pet.findall",query = "select e from Pet e ")
@NamedQuery(name="Pet.findbytype",query = "select e from Pet e where e.type=:type")
@Table(name = "Pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pet_id;
	private String name;
	private String type;
	private int age;
	
	public Pet(Integer pet_id, String name, String type, int age) {
		super();
		this.pet_id = pet_id;
		this.name = name;
		this.type = type;
		this.age = age;
	}
	@ManyToOne
	@JoinColumn(name = "owner_name",referencedColumnName = "owner_name")
	private Owner owner;
	@ManyToMany(mappedBy = "pets")
	private Set<Vet> vets=new HashSet<>();

	public Integer getPet_id() {
		return pet_id;
	}
	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
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
	

}

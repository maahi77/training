package com.asml.petclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@NamedQuery(name="Owner.findall",query = "select e from Owner e ")
@NamedQuery(name="Owner.findbyname",query = "select e from Owner e where e.owner_name=:owner_name")
@Table(name = "Owners")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer owner_id;
	private String owner_name;
	private Long num;
	private String village;
	private String state;
	private Long pincode;
	
	public Owner(Integer owner_id, String owner_name, Long num, String village, String state, Long pincode) {
		super();
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.num = num;
		this.village = village;
		this.state = state;
		this.pincode = pincode;
	}

	@OneToMany(cascade =CascadeType.ALL,fetch=FetchType.EAGER )
	private List<Pet> pets;

	@OneToMany(cascade =CascadeType.ALL)
	private List<Appointment> appointment;

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	

}

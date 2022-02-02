package com.asml.petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* 
 * @author mahendra
 * 
 * Owner class contains details 
 * about owners of pets
 *
 */

@Entity
@NamedQueries({ @NamedQuery(name="Owner.findall",query = "select e from Owner e "),
   @NamedQuery(name="Owner.findbyname",query = "select e from Owner e where e.ownername=:ownername")
})
@Table(name = "Owners")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ownerid;
	private String ownername;
	private Long num;
	private String village;
	private String state;
	private Long pincode;
	
	
	public Owner() {
		super();
	}

	public Owner(Integer ownerid, String ownername, Long num, String village, String state, Long pincode) {
		super();
		this.ownerid = ownerid;
		this.ownername = ownername;
		this.num = num;
		this.village = village;
		this.state = state;
		this.pincode = pincode;
	}

	@OneToMany(cascade =CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "owner" )
	private List<Pet> pets=new ArrayList<>();

	@OneToMany(cascade =CascadeType.ALL,mappedBy = "owner")
	private List<Appointment> appointment=new ArrayList<>();

	public Integer getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
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

	@Override
	public String toString() {
		return "Owner [ownerid=" + ownerid + ", ownername=" + ownername + ", num=" + num + ", village=" + village
				+ ", state=" + state + ", pincode=" + pincode + ", pets=" + pets + ", appointment=" + appointment + "]";
	}
	

}

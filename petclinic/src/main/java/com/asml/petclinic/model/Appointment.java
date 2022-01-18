package com.asml.petclinic.model;

/* 
 * @author mahendra
 * 
 * Appointment class contains details 
 * about appointments details
 *
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NamedQuery(name="Appointment.findall",query = "select e from Appointment e ")
@NamedQuery(name="Appointment.findbyday",query = "select e from Appointment e where e.day=:day")
@Table(name = "Appointments")
public class Appointment {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;
	private double price;
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer stime;
	private String  meridian;
	
	public Appointment(Integer appointment_id, double price, Integer day, Integer month, Integer year, Integer stime,
			String meridian) {
		super();
		this.appointment_id = appointment_id;
		this.price = price;
		this.day = day;
		this.month = month;
		this.year = year;
		this.stime = stime;
		this.meridian = meridian;
	}
	@ManyToOne
	@JoinColumn(name = "owner_name",referencedColumnName = "owner_name")
	private Owner owner;
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Vet vet;

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getStime() {
		return stime;
	}
	public void setStime(Integer stime) {
		this.stime = stime;
	}
	public String getMeridian() {
		return meridian;
	}
	public void setMeridian(String meridian) {
		this.meridian = meridian;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Vet getVet() {
		return vet;
	}
	public void setVet(Vet vet) {
		this.vet = vet;
	}
	
	

}


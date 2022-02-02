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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@NamedQueries ({@NamedQuery(name="Appointment.findall",query = "select e from Appointment e "),
             @NamedQuery(name="Appointment.findbyday",query = "select e from Appointment e where e.day=:day")
  })
@Table(name = "Appointments")
public class Appointment {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentid;
	private double price;
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer stime;
	private String  meridian;
	
	
	
	public Appointment() {
		super();
	}
	public Appointment(Integer appointmentid, double price, Integer day, Integer month, Integer year, Integer stime,
			String meridian) {
		super();
		this.appointmentid = appointmentid;
		this.price = price;
		this.day = day;
		this.month = month;
		this.year = year;
		this.stime = stime;
		this.meridian = meridian;
	}
	@ManyToOne
	@JoinColumn(name = "ownername",referencedColumnName = "ownername")
	private Owner owner;
	@ManyToOne
	@JoinColumn(name = "vetid")
	private Vet vet;

	
	public Integer getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}
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
	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", price=" + price + ", day=" + day + ", month=" + month
				+ ", year=" + year + ", stime=" + stime + ", meridian=" + meridian + ", owner=" + owner + ", vet=" + vet
				+ "]";
	}
	
	

}


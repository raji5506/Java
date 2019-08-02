package com.kovanlabs.jobportal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String addressLine1, city;
//private String state,country;    
//private int pincode;    
 
	@PrimaryKeyJoinColumn
	private Candidate candidate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
//
//public String getState() {
//	return state;
//}
//
//public void setState(String state) {
//	this.state = state;
//}
//
//public String getCountry() {
//	return country;
//}
//
//public void setCountry(String country) {
//	this.country = country;
//}
//
//public int getPincode() {
//	return pincode;
//}
//
//public void setPincode(int pincode) {
//	this.pincode = pincode;
//}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public AddressDetails(String addressLine1, String city) {
		this.addressLine1 = addressLine1;
		this.city = city;
	}

	public AddressDetails() {
	}

}

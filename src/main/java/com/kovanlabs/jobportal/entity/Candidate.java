package com.kovanlabs.jobportal.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "candidate")
public class Candidate implements Serializable  {

	// PrimaryKey
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private long id;

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private int phoneNumber;
 
	@OneToOne(cascade = CascadeType.ALL)
  
	private AddressDetails address;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "candidateId")
//	@OrderColumn(name = "orderId")
//	private List<EducationDetails> educationDetails;

	public long getId() {
		return id;
	}

	public Candidate() {
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressDetails getAddress() {
		return address;
	}

	public void setAddress(AddressDetails address) {
		this.address = address;
	}

//	public List<EducationDetails> getEducationDetails() {
//		return educationDetails;
//	}
//
//	public void setEducationDetails(List<EducationDetails> educationDetails) {
//		this.educationDetails = educationDetails;
//	}
//
//	public Candidate(  String firstName, String lastName, String username, String password, String email,
//			int phoneNumber, AddressDetails address, List<EducationDetails> educationDetails) {
//		super();
//	 
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//		this.address = address;
//		this.educationDetails = educationDetails;
//	}

	public Candidate(String firstName, String lastName, String username, String password, String email, int phoneNumber,
			AddressDetails address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

}

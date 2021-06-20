package com.rest.RestfulStudentCrud.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sudent")
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int studId;
	
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="Age")
	private int studAge;
	@Column(name="Gender")
	private int genderId;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, int studAge, int genderId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studAge = studAge;
		this.genderId = genderId;
	}
	
	
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
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
	public int getStudAge() {
		return studAge;
	}
	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	
	

}

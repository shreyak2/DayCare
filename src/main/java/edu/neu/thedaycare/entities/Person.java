package edu.neu.thedaycare.entities;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Person {

	public enum Gender {
	    MALE, FEMALE
	}
	
	private String firstName;
	private String lastName;
	public Gender gender;

	public Person() {}

	public Person(String firstName, String lastName, Gender gender) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGender(gender);
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}

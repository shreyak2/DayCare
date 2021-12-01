package edu.neu.thedaycare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Guardian extends Person {
	
	public enum Relationship {
	    Father, Mother, Relative
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;
	private Long phone;
	private Relationship relationship;
	private String occupation;

	private Boolean isPrimary;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

	public Guardian() {
		super();
	}

	public Guardian(
			Long id, String firstName,
			String lastName,
			Gender gender,
			String email,
			Long phone,
			Relationship relationship,
			String occupation,
			Boolean primary,
			Student student) {
		super(firstName, lastName, gender);

		this.setId(id);
		this.setEmail(email);
		this.setPhone(phone);
		this.setRelationship(relationship);
		this.setOccupation(occupation);
		this.setIsPrimary(primary);
		this.setStudent(student);
	}
	
	@Override
	public String toString() {
		return "Guardian [getId()=" + getId() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone()
				+ ", getRelationship()=" + getRelationship() + ", getOccupation()=" + getOccupation()
				+ ", getPrimary()=" + getIsPrimary()
				+ ", getStudent()=" + getStudent() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getGender()=" + getGender() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}

}

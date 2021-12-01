package edu.neu.thedaycare.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class ImmunizationRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ImmunizationRequirements immunizationRequirements;
    
    private LocalDate whenDate;

	@Override
	public String toString() {
		return "ImmunizationRecords [getId()=" + getId() + ", getStudent()=" + getStudent()
				+ ", getImmunizationRequirements()=" + getImmunizationRequirements() + ", getWhen()=" + getWhenDate() + "]";
	}

	public ImmunizationRecords() {}

	public ImmunizationRecords(Long id, Student student, ImmunizationRequirements immunizationRequirements,
			LocalDate when) {
		super();
		this.setId(id);
		this.setStudent(student);
		this.setImmunizationRequirements(immunizationRequirements);
		this.setWhenDate(when);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ImmunizationRequirements getImmunizationRequirements() {
		return immunizationRequirements;
	}

	public void setImmunizationRequirements(ImmunizationRequirements immunizationRequirements) {
		this.immunizationRequirements = immunizationRequirements;
	}

	public LocalDate getWhenDate() {
		return whenDate;
	}

	public void setWhenDate(LocalDate when) {
		this.whenDate = when;
	}
    
	
}

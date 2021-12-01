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
public class Teacher extends Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double salary;
	private LocalDate doj;
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Classroom classrooms;
    
	public Teacher() {}

	public Teacher(Long id, String firstName, String lastName, Gender gender, Double salary, LocalDate doj) {
		super(firstName, lastName, gender);

		this.setDoj(doj);
		this.setId(id);
		this.setSalary(salary);
	}

	@Override
	public String toString() {
		return "Teacher [getId()=" + getId() + ", getSalary()=" + getSalary() + ", getDoj()=" + getDoj() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Classroom getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Classroom classrooms) {
		this.classrooms = classrooms;
	}
	
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}

}

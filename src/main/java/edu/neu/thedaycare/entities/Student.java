package edu.neu.thedaycare.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Student extends Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDate dob;
	private LocalDate programStartDate;
	private Integer grade;
	
	@Transient
	private Integer age;
	
	@Transient
	private String fullName;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Guardian> guardians;
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Classroom classroom;
    
	private LocalDate registrationDate;
	
	public String fullName() {
		return this.getFirstName() + " " + this.getLastName();
	}
	
	public Student() {
		super();
	}

	public Student(
			Long id,
			String firstName,
			String lastName,
			Gender gender,
			LocalDate dob,
			LocalDate programStartDate,
			Integer grade,
			LocalDate registrationDate) {
		super(firstName, lastName, gender);

		this.setId(id);
		this.setDob(dob);;
		this.setProgramStartDate(programStartDate);
		this.setGrade(grade);
		this.setRegistrationDate(registrationDate);
	}
	
	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getDob()=" + getDob() + ", getProgramStartDate()="
				+ getProgramStartDate() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getGender()=" + getGender() + "]";
	}
	
	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getMonths();
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getProgramStartDate() {
		return programStartDate;
	}
	public void setProgramStartDate(LocalDate programStartDate) {
		this.programStartDate = programStartDate;
	}
	
	public Classroom getClassroom() {
		return this.classroom;
	}
	
	public List<Guardian> getGuardians() {
		return this.guardians;
	}
	
	public Guardian getPrimaryGuardian() {
		return this.guardians.stream().filter(g -> g.getIsPrimary()).findFirst().get();
	}
	
}

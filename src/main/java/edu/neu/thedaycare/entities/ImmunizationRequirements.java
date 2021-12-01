package edu.neu.thedaycare.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class ImmunizationRequirements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String level; // Preschool, Kindergarten
	private String name;
	private Integer doses;
	private Integer monthsApart; // when to take the next dose
	
	@Override
	public String toString() {
		return "ImmunizationRequirements [getId()=" + getId() + ", getLevel()=" + getLevel() + ", getName()="
				+ getName() + ", getDoses()=" + getDoses() + ", getMonthsApart()=" + getMonthsApart() + "]";
	}

	public ImmunizationRequirements() {}
	
	public ImmunizationRequirements(Long id, String level, String name, Integer doses, Integer monthsApart) {
		super();
		this.setId(id);
		this.setLevel(level);
		this.setName(name);
		this.setDoses(doses);
		this.setMonthsApart(monthsApart);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDoses() {
		return doses;
	}
	public void setDoses(Integer doses) {
		this.doses = doses;
	}
	public Integer getMonthsApart() {
		return monthsApart;
	}
	public void setMonthsApart(Integer monthsApart) {
		this.monthsApart = monthsApart;
	}
	

}

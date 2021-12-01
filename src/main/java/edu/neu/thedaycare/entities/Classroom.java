package edu.neu.thedaycare.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

import edu.neu.thedaycare.repository.StudentRepository;

@Entity
@Table
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer strength;
	private String className;
	private Integer groupSize;
	private Integer maxGroups;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Teacher> teachers;
	
	public Classroom() {}
	
	public Classroom(Long id, String className, Integer strength, Integer groupSize, Integer maxGroups,
			List<Student> students, List<Teacher> teachers) {
		this.setId(id);
		this.setStrength(strength);
		this.setGroupSize(groupSize);
		this.setMaxGroups(maxGroups);
		this.setStudents(students);
		this.setTeachers(teachers);
		this.setClassName(className);
	}

	@Override
	public String toString() {
		return "Classroom [getId()=" + getId() + ", getStrength()=" + getStrength() + ", getGroupName()="
				+ ", getGroupSize()=" + getGroupSize() + ", getMaxGroups()=" + getMaxGroups()
				+ ", getStudents()=" + getStudents() + ", getTeachers()=" + getTeachers() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}

	public Integer getMaxGroups() {
		return maxGroups;
	}

	public void setMaxGroups(Integer maxGroups) {
		this.maxGroups = maxGroups;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRatio() {
		List<Teacher> t = this.getTeachers();
		List<Student> s = this.getStudents();

		Integer ratio = this.students.size() / this.teachers.size();

		String r = "" + ratio + ":" + "1";
		
		return r;
	}
	
}

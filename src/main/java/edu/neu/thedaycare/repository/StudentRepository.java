package edu.neu.thedaycare.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.neu.thedaycare.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>  {

}

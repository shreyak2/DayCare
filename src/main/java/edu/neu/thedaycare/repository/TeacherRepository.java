package edu.neu.thedaycare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.thedaycare.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

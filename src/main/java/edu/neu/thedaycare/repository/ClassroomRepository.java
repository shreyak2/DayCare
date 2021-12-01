package edu.neu.thedaycare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.thedaycare.entities.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}

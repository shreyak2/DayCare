package edu.neu.thedaycare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.thedaycare.entities.ImmunizationRequirements;

public interface ImmunizarionRequirementsRepository extends JpaRepository<ImmunizationRequirements, Long> {
	List<ImmunizationRequirements> findByLevel(String level);
}

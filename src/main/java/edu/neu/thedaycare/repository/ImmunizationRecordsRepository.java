package edu.neu.thedaycare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.thedaycare.entities.ImmunizationRecords;

public interface ImmunizationRecordsRepository extends JpaRepository<ImmunizationRecords, Long> {
	public List<ImmunizationRecords> findAllByStudentId(Long id);
	public List<ImmunizationRecords> findAllByImmunizationRequirementsId(Long id);
}

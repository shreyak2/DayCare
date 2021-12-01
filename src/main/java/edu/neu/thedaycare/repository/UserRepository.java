package edu.neu.thedaycare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.thedaycare.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer>  {
	
	Optional<Users> findByUsername(String username);

}

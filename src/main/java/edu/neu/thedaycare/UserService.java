package edu.neu.thedaycare;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.neu.thedaycare.entities.Users;
import edu.neu.thedaycare.repository.UserRepository;
import edu.neu.thedaycare.entities.UserDetailsSecurity;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		
		return user.map(UserDetailsSecurity::new).get();
	}

}

package com.example.springsecurityjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurityjpa.dao.UserDaoRepository;
import com.example.springsecurityjpa.model.MyUserDetails;
import com.example.springsecurityjpa.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDaoRepository userDaoRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//return hard code user from class MyUserDetails for test.
		//return new MyUserDetails(username);
		
		//calling out own JPA Repository class to get user obj.
		Optional<User> user = userDaoRepo.findByUserName(username);
		//If in case user is not found, throw exception.
		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
		//if user is found, then create a new obj of type 'MyUserDetails' from the option user obj & return it.
		return user.map(MyUserDetails::new).get();
	}

}

package com.example.springsecurityjpa.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springsecurityjpa.model.User;

public interface UserDaoRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
	//Above line tells JPA that we now need a method which takes a 'username' and finds a User object.
	//And JPA will create the implementation for us w/o we actually required to create it
	
}

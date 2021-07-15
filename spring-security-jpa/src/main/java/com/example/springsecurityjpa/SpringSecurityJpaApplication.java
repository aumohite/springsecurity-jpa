package com.example.springsecurityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.springsecurityjpa.dao.UserDaoRepository;

@EnableJpaRepositories(basePackageClasses = UserDaoRepository.class)
@SpringBootApplication
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}

}

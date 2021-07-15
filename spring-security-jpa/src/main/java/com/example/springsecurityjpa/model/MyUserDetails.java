package com.example.springsecurityjpa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.dialect.MySQL57Dialect;
//import org.hibernate.dialect.MySQL55Dialect;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private String userName; //MySQL57Dialect
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();	
	
	public MyUserDetails(String userName) {
		this.userName = userName;
	}
	/*
	 * public MyUserDetails() { }
	 */

	/*public MyUserDetails(Optional<User> user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		// -- below is the same thing done as above
		// for (String role : user.getRoles().split(",")) { 
		// 		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		// 		this.authorities.add(authority); 
		// };
		//
	}*/
	
	public MyUserDetails(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		/* -- below is the same thing done as above
		 * for (String role : user.getRoles().split(",")) { 
		 * 		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		 * 		this.authorities.add(authority); 
		 * };
		 */
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}

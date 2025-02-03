package com.eob.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eob.entity.Users;
import com.eob.repository.UsersRepository;

@Component
public class UsersInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository respository;

	public UserDetails loadUserByUsername(String username)  {
		Optional<Users> userInfo = respository.getByUsername(username);
		return userInfo.map(UsersInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}
	
}

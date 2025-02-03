package com.eob.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eob.entity.Users;
import com.eob.repository.RolesRepository;
import com.eob.repository.UsersRepository;

@Service
public class UsersService {

	
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*public UsersService(UsersRepository usersRepository, RolesRepository rolesRepository) {
		this.usersRepository = usersRepository;
		this.rolesRepository = rolesRepository;
	}*/

	public Users saveUserWithRole(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreated_at(LocalDateTime.now());
		user.setUpdated_at(LocalDateTime.now());
		return usersRepository.save(user);
	}

	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	public Users getUserById(Integer userId) {
		return usersRepository.findById(userId).orElse(null);
	}

	public List<Users> findUserByName(String name){
		return usersRepository.findByUsername(name);
	}
	
	public Users updateUser(Integer userId, Users userDetails) {
		Users user = getUserById(userId);
		if (user != null) {
			user.setUsername(userDetails.getUsername());
			user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
			//user.setPassword(userDetails.getPassword());
			user.setEmail(userDetails.getEmail());
			user.setRoles(userDetails.getRoles());
			user.setUpdated_at(LocalDateTime.now());
			return usersRepository.save(user);
		}
		return null;
	}

	public void deleteUser(Integer userId) {
		usersRepository.deleteById(userId);
	}
	
}

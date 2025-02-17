package com.eob.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.eob.dto.RoleDTO;
import com.eob.dto.UserDTO;
import com.eob.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eob.entity.Users;
import com.eob.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Users saveUserWithRole(UserDTO userDTO) {

		Set<RoleDTO> roles = userDTO.getRoles();
		Set<Roles> setRoles = new HashSet<>();		
		for (RoleDTO dto : roles) {
			Roles role = new Roles();
			role.setRolename(dto.getRolename());
			String result = String.join(", ", dto.getPermissions());
			role.setPermissions(result);
			role.setRolename(dto.getRolename());
			setRoles.add(role);
		}

		Users users = new Users();
		users.setUsername(userDTO.getUsername());
		users.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		users.setEmail(userDTO.getEmail());
		users.setRoles(setRoles);
		users.setCreated_at(LocalDateTime.now());
		users.setUpdated_at(LocalDateTime.now());
		return usersRepository.save(users);

	}

	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	public Users getUserById(Integer userId) {
		return usersRepository.findById(userId).orElse(null);
	}

	public List<Users> findUserByName(String name) {
		return usersRepository.findByUsername(name);
	}

	public Users updateUser(Integer userId, Users userDetails) {
		Users user = getUserById(userId);
		if (user != null) {
			user.setUsername(userDetails.getUsername());
			user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
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

	public void deleteUser(Integer userId) {
		usersRepository.deleteById(userId);
	}
	
}

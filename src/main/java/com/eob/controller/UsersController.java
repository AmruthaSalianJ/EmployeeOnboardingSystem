package com.eob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eob.dto.UserDTO;
import com.eob.entity.Roles;
import com.eob.entity.Users;
import com.eob.service.RolesService;
import com.eob.service.UsersService;

@RestController
@RequestMapping("/api/users/roles")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private RolesService rolesService;

	@PostMapping(value = "/new")
	public ResponseEntity<?> saveUserWithRole(@RequestBody UserDTO user) {
		return new ResponseEntity<>(usersService.saveUserWithRole(user), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ITADMIN', 'ROLE_ADMIN')")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER', 'ROLE_ADMIN')")
	public Users getUserById(@PathVariable Integer id) {
		return usersService.getUserById(id);
	}

	@GetMapping("/find/{username}")
	@PreAuthorize("hasAuthority('ROLE_ITADMIN', 'ROLE_ADMIN')")
	public List<Users> findUsersByName(@PathVariable String username) {
		return usersService.findUserByName(username);
	}

	@GetMapping("search/{rolename}")
	@PreAuthorize("hasAuthority('ROLE_ITADMIN', 'ROLE_ADMIN')")
	public List<Roles> findUsersByRoleName(@PathVariable String rolename) {
		return rolesService.findUsersByRoleName(rolename);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ITADMIN', 'ROLE_ADMIN')")
	public Users updateUser(@PathVariable Integer id, @RequestBody Users user) {
		return usersService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ITADMIN')")
	public void deleteUser(@PathVariable Integer id) {
		usersService.deleteUser(id);
	}

}

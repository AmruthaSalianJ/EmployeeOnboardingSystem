package com.eob.service;

import java.util.List;
import java.util.Optional;

import com.eob.entity.Role;

public interface RoleService {

	Role findById(Integer roleId);
	
	List<Role> getRole();
	
	void save(Role role);
	
	void delete(Role role);
	
}

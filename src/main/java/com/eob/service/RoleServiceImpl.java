package com.eob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eob.entity.Role;
import com.eob.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public Role findById(Integer roleId) {
		return roleRepo.findById(roleId).get();
	}

	@Override
	public List<Role> getRole() {
		return roleRepo.findAll();
	}

	@Override
	public void save(Role role) {
		roleRepo.save(role);
	}

	@Override
	public void delete(Role role) {
		roleRepo.delete(role);
	}

}

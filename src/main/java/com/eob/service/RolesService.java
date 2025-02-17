package com.eob.service;

import java.util.List;

import com.eob.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eob.entity.Roles;
import com.eob.repository.RolesRepository;

@Service
public class RolesService {

	@Autowired
    private RolesRepository rolesRepository;

    public Roles saveRole(UserDTO user) {
        return null;
    }

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles getRoleById(Integer roleId) {
        return rolesRepository.findById(roleId).orElse(null);
    }

    public List<Roles> findUsersByRoleName(String rolename) {
		return rolesRepository.findByRolename(rolename);
	}
    
  
    public Roles updateRole(Integer roleId, Roles roleDetails) {
        Roles role = getRoleById(roleId);
        if (role != null) {
            role.setRolename(roleDetails.getRolename());
            role.setPermissions(roleDetails.getPermissions());
            role.setUsers(roleDetails.getUsers());
            return rolesRepository.save(role);
        }
        return null;
    }
    
    public void deleteRole(Integer roleId) {
        rolesRepository.deleteById(roleId);
    }
	
}

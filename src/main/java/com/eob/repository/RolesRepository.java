package com.eob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eob.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

	List<Roles> findByRolename(String rolename);
	
}

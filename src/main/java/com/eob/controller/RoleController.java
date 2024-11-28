package com.eob.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eob.entity.Role;
import com.eob.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/roles")
	public ResponseEntity<?> getRole() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<Role> roleList = roleService.getRole();
		if (!roleList.isEmpty()) {
			map.put("status", 1);
			map.put("data", roleList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveRole(@RequestBody Role role) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		roleService.save(role);
		map.put("status", 1);
		map.put("message", "Record is saved successfully!");

		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/roles/{roleId}")
	public ResponseEntity<?> getRoleById(@PathVariable Integer roleId) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Role role = roleService.findById(roleId);
			map.put("status", 1);
			map.put("data", role);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.clear();
			map.put("status", 0);
			map.put("data", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{roleId}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer roleId) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Role role = roleService.findById(roleId);
			roleService.delete(role);
			map.put("status", 1);
			map.put("message", "Record deleted successfully");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	

}

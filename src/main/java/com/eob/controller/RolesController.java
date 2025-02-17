package com.eob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.eob.service.RolesService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

	@Autowired
    private RolesService rolesService;

    @PostMapping("/new")
    public Roles createRole(@RequestBody UserDTO userDTO) {
        return rolesService.saveRole(userDTO);
    }

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Roles getRoleById(@PathVariable Integer id) {
        return rolesService.getRoleById(id);
    }

    @PutMapping("/{id}")
    public Roles updateRole(@PathVariable Integer id, @RequestBody Roles role) {
        return rolesService.updateRole(id, role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Integer id) {
        rolesService.deleteRole(id);
    }
    
}

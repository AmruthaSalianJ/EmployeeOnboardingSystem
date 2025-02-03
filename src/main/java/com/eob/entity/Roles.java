package com.eob.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ROLES_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles implements Serializable {

	private static final long serialVersionUID = -3944316944182052272L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rolename;
	private String permissions;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Users> users;
	
	

}

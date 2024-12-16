package com.eob.entity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int task_id;
	
	
	//fKey
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<WorkFlow> workFlow = new ArrayList<>();
	
	
	
	@Column(name = "task_name",columnDefinition="Text",nullable=false)
	private String task_name;
	
	@Column(name = "assigned_to")
	private int assigned_to; 
	
	@Column(name = "status",columnDefinition="TEXT", nullable=false)
	private String status;
	
	@Column(name="due_date",nullable=false,updatable = false)
	private LocalDateTime due_date;
	
	@Column(name="completed_at",nullable=false,updatable = false)
	private LocalDateTime completed_at;

}

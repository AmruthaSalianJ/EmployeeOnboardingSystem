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
	//@OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private List<WorkFlow> workFlow = new ArrayList<>();
	
	
	
	@Column(name = "task_name",columnDefinition="Text",nullable=false)
	private String taskName;
	
	@Column(name = "assigned_to")
	private int assignedTo; 
	
	@Column(name = "status",columnDefinition="TEXT", nullable=false)
	private String status;
	
	@Column(name="due_date",nullable=false,updatable = false)
	private LocalDateTime dueDate;
	
	@Column(name="completed_at",nullable=false,updatable = false)
	private LocalDateTime completedAt;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

//	public List<WorkFlow> getWorkFlow() {
//		return workFlow;
//	}
//
//	public void setWorkFlow(List<WorkFlow> workFlow) {
//		this.workFlow = workFlow;
//	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}
  
}

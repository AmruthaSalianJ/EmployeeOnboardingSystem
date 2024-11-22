package com.eob.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "workflow")
public class WorkFlow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workflow_id")
	private int workflowId;
	
	@Column(name = "workflow_name",nullable=false)
	private String workflowName;
	
	@Column(name = "description",columnDefinition="TEXT", nullable=false)
	private String description;
	
	@Column(name="created_at",nullable=false,updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at",nullable=false,updatable = false)
	private LocalDateTime updatedAt;

	//fkeys
	@ManyToOne
	private Task task;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}

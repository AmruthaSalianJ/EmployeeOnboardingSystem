package com.eob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eob.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}

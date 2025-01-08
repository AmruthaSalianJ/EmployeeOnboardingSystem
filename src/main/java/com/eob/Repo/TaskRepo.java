package com.eob.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eob.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}

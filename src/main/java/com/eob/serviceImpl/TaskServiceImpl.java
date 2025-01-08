package com.eob.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eob.Repo.TaskRepo;
import com.eob.Service.TaskService;
import com.eob.entity.Task;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(int taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.orElseThrow(() -> new RuntimeException("Task not found with ID: " + taskId));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(int taskId, Task updatedTask) {
        Task existingTask = getTaskById(taskId);
        existingTask.setTaskName(updatedTask.getTaskName());
        existingTask.setAssignedTo(updatedTask.getAssignedTo());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setCompletedAt(updatedTask.getCompletedAt());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(int taskId) {
        Task task = getTaskById(taskId);
        taskRepository.delete(task);
    }
}

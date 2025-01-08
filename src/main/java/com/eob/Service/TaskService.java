package com.eob.Service;

import java.util.List;

import com.eob.entity.Task;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(int taskId);
    List<Task> getAllTasks();
    Task updateTask(int taskId, Task updatedTask);
    void deleteTask(int taskId);
}

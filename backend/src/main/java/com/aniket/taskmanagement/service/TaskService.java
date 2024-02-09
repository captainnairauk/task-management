package com.aniket.taskmanagement.service;

import com.aniket.taskmanagement.model.Task;

public interface TaskService {
    Task addTask(Task task);
    Task updateTask(Long taskId, Task updatedTask);

    void deleteTask(Long taskId);
}

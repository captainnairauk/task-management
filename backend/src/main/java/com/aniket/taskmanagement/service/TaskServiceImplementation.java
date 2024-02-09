package com.aniket.taskmanagement.service;

import com.aniket.taskmanagement.model.Task;
import com.aniket.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImplementation implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(()-> new RuntimeException("Task not found"));
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDueDate(updatedTask.getDueDate());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}

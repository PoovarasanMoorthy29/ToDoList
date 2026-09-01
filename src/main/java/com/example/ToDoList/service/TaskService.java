package com.example.ToDoList.service;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    ITaskRepository taskRepository;

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void markTaskCompleted(Integer id){
        Task task = taskRepository.findById(id).orElse(new Task());
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(int id , Task task) {
        Task updateTask= taskRepository.findById(id).orElse(new Task());
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        updateTask.setCompleted(task.isCompleted());
        taskRepository.save(updateTask);
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }
}

package com.example.ToDoList.service;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    ITaskRepository iTaskRepository;

    public void createTask(Task task) {
        iTaskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return iTaskRepository.findAll();
    }

    public void markTaskCompleted(Integer id){
        Task task = iTaskRepository.findById(id).get();
        task.setCompleted(true);
        iTaskRepository.save(task);
    }

    public void deleteTaskById(Integer id) {
        iTaskRepository.deleteById(id);
    }

    public void changeTitleOfTask(Task task) {
        Task updateTask=iTaskRepository.findById(task.getId()).get();
        updateTask.setTitle(task.getTitle());
        iTaskRepository.save(updateTask);
    }

    public void changeDescriptionOfTask(Task task) {
        Task updateTask=iTaskRepository.findById(task.getId()).get();
        updateTask.setDescription(task.getDescription());
        iTaskRepository.save(updateTask);
    }
}

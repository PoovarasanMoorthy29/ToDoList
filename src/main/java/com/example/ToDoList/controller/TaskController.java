package com.example.ToDoList.controller;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping
    public String createNewTask(@RequestBody Task task){
        service.createTask(task);
        return "Task Created!";
    }

    @GetMapping
    public List<Task> getAllTask(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskByID(@PathVariable int id){
        return service.getTaskById(id);
    }
    @PutMapping("/{id}")
    public String updateTask(@PathVariable int id ,@RequestBody Task task){
        service.updateTask(id,task);
        return "Task  Updated!";
    }

    @PutMapping("/{id}/complete")
    public String makeTaskCompleted(@PathVariable Integer id){
        service.markTaskCompleted(id);
        return "task completed!";
    }
    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Integer id){
        service.deleteTaskById(id);
        return "Task Deleted!";
    }
}

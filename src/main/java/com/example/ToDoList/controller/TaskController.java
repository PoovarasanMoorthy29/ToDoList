package com.example.ToDoList.controller;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todolist")
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping("/create/newtask")
    public String createNewTask(@RequestBody Task task){
        service.createTask(task);
        return "Task Created!";
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTask(){
        return service.getAllTasks();
    }

    @PutMapping("/markTaskcompleted/{id}")
    public String makeTaskCompleted(@PathVariable Integer id){
        service.markTaskCompleted(id);
        return "task completed!";
    }
    @DeleteMapping("/deleteTaskByID/{id}")
    public String deleteTaskById(@PathVariable Integer id){
        service.deleteTaskById(id);
        return "Task Deleted!";
    }



}

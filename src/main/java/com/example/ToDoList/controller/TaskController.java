package com.example.ToDoList.controller;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getTasks/{id}")
    public Optional<Task> getTask(@PathVariable int id){
        return service.getTaskById(id);
    }
    @PutMapping("/changeTitle")
    public String changeTitleOfTask(@RequestBody Task task){
        service.changeTitleOfTask(task);
        return "Title Updated!";
    }
    @PutMapping("/change-description")
    public String changeDescriptionOfTask(@RequestBody Task task){
        service.changeDescriptionOfTask(task);
        return "Description Updated!";
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

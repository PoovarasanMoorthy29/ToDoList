package com.example.ToDoList.controller;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping
    public ResponseEntity<String> createNewTask(@RequestBody Task task){
        service.createTask(task);
        return new ResponseEntity<>("Task Created....",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(service.getAllTasks());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable int id){
        Task task= service.getTaskById(id);
        if(task!=null){
            return new ResponseEntity<>(task,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id ,@RequestBody Task task){
        service.updateTask(id,task);
        return new ResponseEntity<>("Task Updated...", HttpStatus.OK);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<String>  makeTaskCompleted(@PathVariable Integer id){
        service.markTaskCompleted(id);
        return new ResponseEntity<>("task completed!",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Integer id){
        service.deleteTaskById(id);
        return new ResponseEntity<>("Task Deleted!",HttpStatus.OK);
    }
}

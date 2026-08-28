package com.example.ToDoList.repository;

import com.example.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task ,Integer> {
}

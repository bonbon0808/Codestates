package com.solo.todolist.todo.repository;

import com.solo.todolist.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}

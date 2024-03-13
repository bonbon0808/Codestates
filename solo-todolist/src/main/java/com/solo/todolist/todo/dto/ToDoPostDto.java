package com.solo.todolist.todo.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class ToDoPostDto {
//    private long id;

    private String title;

    private int todoOrder;

    private boolean completed;



}

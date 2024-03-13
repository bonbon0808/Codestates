package com.solo.todolist.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoResponseDto {
    private long id;
    private String title;
    private int todoOrder;
    private boolean completed;
}

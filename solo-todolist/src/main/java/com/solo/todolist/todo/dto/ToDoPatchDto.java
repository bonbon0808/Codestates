package com.solo.todolist.todo.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class ToDoPatchDto {
    private long id;

    private String title;

    private int todoOrder;

    private boolean completed;


    public void setId(long id) {
        this.id = id;
    }

}

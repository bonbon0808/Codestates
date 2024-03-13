package com.solo.todolist.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private int todoOrder;

    // nullalbe = false 값을 지정해주지 않아도 필드를 누락할 경우 기본으로 false가 되는듯?
    @Column(nullable = false)
    private boolean completed;
}

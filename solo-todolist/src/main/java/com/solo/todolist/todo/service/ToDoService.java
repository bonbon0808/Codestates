package com.solo.todolist.todo.service;

import com.solo.todolist.todo.entity.ToDo;
import com.solo.todolist.todo.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDoList(ToDo toDo) {

        return toDoRepository.save(toDo);
    }

    public ToDo updateToDoList(long id, String title, int todoOrder, boolean completed) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // 요청할 때 필드를 누락시킨 경우 기본값(null 혹은 0)으로 설정되게 하지 않도록 설정
        if (title != null) {
            toDo.setTitle(title);
        }

        if (todoOrder != 0) {
            toDo.setTodoOrder(todoOrder);
        }


        toDo.setCompleted(completed);

        return toDoRepository.save(toDo);

    }

    public ToDo findToDoList(long id) {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public List<ToDo> findToDoLists() {
        return toDoRepository.findAll();
    }

    public void deleteToDoList(long id) {
        toDoRepository.deleteById(id);
    }

    public void deleteToDoLists() {
        toDoRepository.deleteAll();

    }

}

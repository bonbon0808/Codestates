package com.solo.todolist.todo.controller;

import com.solo.todolist.todo.mapper.ToDoMapper;
import com.solo.todolist.todo.service.ToDoService;
import com.solo.todolist.todo.dto.ToDoPatchDto;
import com.solo.todolist.todo.dto.ToDoPostDto;
import com.solo.todolist.todo.dto.ToDoResponseDto;
import com.solo.todolist.todo.entity.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todolist")
@Validated
public class ToDoController {

    private final ToDoService toDoService;
    private final ToDoMapper toDoMapper;

    public ToDoController(ToDoService toDoService, ToDoMapper toDoMapper) {
        this.toDoService = toDoService;
        this.toDoMapper = toDoMapper;
    }

    // create 할 일 목록 등록
    @PostMapping
    public ResponseEntity postList(@RequestBody ToDoPostDto toDoPostDtoDto) {
        ToDo toDo = toDoMapper.todoPostDtoTotodo(toDoPostDtoDto);

        ToDo response = toDoService.createToDoList(toDo);

        return new ResponseEntity<>(toDoMapper.todoToToDoResponseDto(response), HttpStatus.CREATED);
    }


    // update 할 일 내용 수정, 이미 한 일에는 완료로 표시하기
    // ** 생각해보기 요청에 하나의 값(필드)만 넣었을 경우 나머지는 초기화가 되는 문제. -> 서비스쪽에서 로직 수정함.
    @PatchMapping("/{id}")
    public ResponseEntity patchUpdateList(@PathVariable("id") @Min(1) long id,
                                          @RequestBody ToDoPatchDto toDoPatchDto) {
        toDoPatchDto.setId(id);

        ToDo response = toDoService.updateToDoList(toDoMapper.todoPatchDtoTotodo(toDoPatchDto).getId(),
                toDoPatchDto.getTitle(),
                toDoPatchDto.getTodoOrder(),
                toDoPatchDto.isCompleted());

        return new ResponseEntity<>(toDoMapper.todoToToDoResponseDto(response), HttpStatus.OK);

    }

    // read 전체 할일 목록 조회 , 특정 id로 조회
    @GetMapping("/{id}")
    public ResponseEntity findList(@PathVariable("id") @Min(1) long id) {

        ToDo response = toDoService.findToDoList(id);

        return new ResponseEntity<>(toDoMapper.todoToToDoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findLists() {
        List<ToDo> todos = toDoService.findToDoLists();

        List<ToDoResponseDto> response =
                todos.stream()
                        .map(toDo -> toDoMapper.todoToToDoResponseDto(toDo))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // delete 전체 할 일 삭제, 특정 id로 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteList(@PathVariable("id") @Min(1) long id) {

        toDoService.deleteToDoList(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity deleteLists() {

        toDoService.deleteToDoLists();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

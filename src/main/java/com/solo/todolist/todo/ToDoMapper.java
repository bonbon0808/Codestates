package com.solo.todolist.todo;

import org.mapstruct.Mapper;

/**
 * @Mapper 애너테이션 애트리뷰트로 componentModel = "spring" 지정해 주면 Spring Bean으로 등록됨
 */
@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDo todoPostDtoTotodo(ToDoPostDto toDoPostDto);
    ToDo todoPatchDtoTotodo(ToDoPatchDto toDoPatchDto);

    ToDoResponseDto todoToToDoResponseDto(ToDo toDo);



}

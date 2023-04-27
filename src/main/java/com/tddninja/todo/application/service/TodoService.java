package com.tddninja.todo.application.service;

import com.tddninja.todo.application.entity.Task;
import com.tddninja.todo.application.entity.Todo;

import java.util.List;

public interface TodoService {

    Long createTodo(Todo todo);

    Todo getTodo(Long todoId);

    void updateTodo(Todo todo);

    void deleteTodo(Long todoId);

    List<Todo> getTodo();

}

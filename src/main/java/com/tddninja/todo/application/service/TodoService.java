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

    Long createTask(Long todoId, Task task);

    Task getTask(Long todoId, Long taskId);

    List<Task> getAllTask(Long todoId);

    void updateTask(Task task);

    void deleteTask(Long taskId);

}

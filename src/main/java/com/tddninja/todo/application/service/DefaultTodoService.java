package com.tddninja.todo.application.service;

import com.tddninja.todo.application.entity.Todo;
import com.tddninja.todo.application.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultTodoService implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public Long createTodo(Todo todo) {
        Todo entity = todoRepository.save(todo);
        return entity.getId();
    }

    @Override
    public Todo getTodo(Long todoId) {
        return todoRepository.findById(todoId).orElse(null);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.updateTodo(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);

    }

    @Override
    public List<Todo> getTodo() {
        return todoRepository.findAll();
    }
}

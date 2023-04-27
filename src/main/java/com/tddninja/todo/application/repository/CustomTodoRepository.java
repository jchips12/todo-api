package com.tddninja.todo.application.repository;

import com.tddninja.todo.application.entity.Todo;
import jakarta.transaction.Transactional;

public interface CustomTodoRepository {

    @Transactional
    void updateTodo(Todo todo);

}

package com.tddninja.todo.application.repository;

import com.tddninja.todo.application.entity.Task;
import com.tddninja.todo.application.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTodo(Todo todo);
}

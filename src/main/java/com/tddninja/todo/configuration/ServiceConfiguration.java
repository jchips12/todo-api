package com.tddninja.todo.configuration;

import com.tddninja.todo.application.repository.TaskRepository;
import com.tddninja.todo.application.repository.TodoRepository;
import com.tddninja.todo.application.service.DefaultTodoService;
import com.tddninja.todo.application.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    TodoService todoService(TodoRepository todoRepository, TaskRepository taskRepository) {
        return new DefaultTodoService(todoRepository, taskRepository);
    }
}

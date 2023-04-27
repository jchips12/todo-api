package com.tddninja.todo.configuration;

import com.tddninja.todo.application.repository.TaskRepository;
import com.tddninja.todo.application.repository.TodoRepository;
import com.tddninja.todo.application.service.DefaultTaskService;
import com.tddninja.todo.application.service.DefaultTodoService;
import com.tddninja.todo.application.service.TaskService;
import com.tddninja.todo.application.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    TodoService todoService(TodoRepository todoRepository) {
        return new DefaultTodoService(todoRepository);
    }

    @Bean
    TaskService taskService(TaskRepository taskRepository) {
        return new DefaultTaskService(taskRepository);
    }
}

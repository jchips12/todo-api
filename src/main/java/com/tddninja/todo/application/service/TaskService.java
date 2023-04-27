package com.tddninja.todo.application.service;

import com.tddninja.todo.application.entity.Task;

import java.util.List;

public interface TaskService {

    Long createTask(Long todoId, Task task);

    Task getTask(Long todoId, Long taskId);

    List<Task> getAllTask(Long todoId);

    void updateTask(Task task);

    void deleteTask(Long taskId);

}

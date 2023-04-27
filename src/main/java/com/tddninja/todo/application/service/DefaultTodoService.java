package com.tddninja.todo.application.service;

import com.tddninja.todo.application.entity.Task;
import com.tddninja.todo.application.entity.Todo;
import com.tddninja.todo.application.repository.TaskRepository;
import com.tddninja.todo.application.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultTodoService implements TodoService {

    private final TodoRepository todoRepository;
    private final TaskRepository taskRepository;

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

    @Override
    public Long createTask(Long todoId, Task task) {
        Todo todo = new Todo();
        todo.setId(todoId);
        task.setTodo(todo);
        taskRepository.save(task);
        return task.getId();
    }

    @Override
    public Task getTask(Long todoId, Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public List<Task> getAllTask(Long todoId) {
        return taskRepository.findByTodo(Todo.builder().id(todoId).build());
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}

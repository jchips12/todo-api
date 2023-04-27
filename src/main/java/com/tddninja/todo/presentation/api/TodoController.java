package com.tddninja.todo.presentation.api;

import com.tddninja.todo.application.entity.Task;
import com.tddninja.todo.application.entity.Todo;
import com.tddninja.todo.application.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodo(@PathVariable Long todoId) {
        return todoService.getTodo(todoId);
    }

    @PutMapping("/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTodo(@PathVariable Long todoId, @RequestBody Todo todo) {
        todo.setId(todoId);
        todoService.updateTodo(todo);
    }

    @DeleteMapping("/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodo() {
        return todoService.getTodo();
    }

    @PostMapping("/{todoId}/task")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createTask(@PathVariable Long todoId, @RequestBody Task task) {
        log.info("Creating task under todo id: " + todoId);
        return todoService.createTask(todoId, task);
    }

    @GetMapping("/{todoId}/task")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(@PathVariable Long todoId) {
        return todoService.getAllTask(todoId);
    }

    @GetMapping("/{todoId}/task/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable Long todoId, @PathVariable Long taskId) {
        return todoService.getTask(todoId, taskId);
    }

    @PutMapping("/{todoId}/task/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTodo(@PathVariable Long todoId, @PathVariable Long taskId, @RequestBody Task task) {
        task.setId(taskId);
        task.setTodo(Todo.builder().id(todoId).build());
        todoService.updateTask(task);
    }

    @DeleteMapping("/{}/task/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long taskId) {
        todoService.deleteTask(taskId);
    }
}

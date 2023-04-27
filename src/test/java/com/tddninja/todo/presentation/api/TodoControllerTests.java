package com.tddninja.todo.presentation.api;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.tddninja.todo.application.entity.Status;
import com.tddninja.todo.application.entity.Task;
import com.tddninja.todo.application.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldBeAbleToCreateTodo() {
        Todo request = Todo.builder()
                .title("Todo title")
                .description("Todo description")
                .build();
        ResponseEntity<Long> response = restTemplate.postForEntity("/api/todo", request, Long.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void shouldGetATodo() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/todo", String.class);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.[0].id");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(id).isNotNull();
    }

    @Test
    void shouldGetATodoWithId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/todo/1", String.class);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(id).isEqualTo(1);
    }

    @Test
    void shouldBeAbleToAddTask() {
        Task request = Task.builder()
                .title("Task title")
                .description("Task description")
                .status(Status.TODO)
                .build();
        ResponseEntity<Void> response = restTemplate.postForEntity("/api/todo/1/task", request, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void shouldGetATask() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/todo/1/task", String.class);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.[0].id");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(id).isEqualTo(1);
    }

    @Test
    void shouldDeleteATask() {
        ResponseEntity<Void> response = restTemplate.exchange("/api/todo/1/task/2", HttpMethod.DELETE, null, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}

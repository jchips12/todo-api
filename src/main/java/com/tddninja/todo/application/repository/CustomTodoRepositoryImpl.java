package com.tddninja.todo.application.repository;

import com.tddninja.todo.application.entity.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomTodoRepositoryImpl implements CustomTodoRepository {

    private final EntityManager em;

    @Override
    public void updateTodo(Todo todo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Todo> update = cb.createCriteriaUpdate(Todo.class);

        Root<Todo> e = update.from(Todo.class);
        if (todo.getTitle() != null) {
            update.set("title", todo.getTitle());
        }
        if (todo.getDescription() != null) {
            update.set("description", todo.getDescription());
        }
        update.where(cb.equal(e.get("id"), todo.getId()));

        em.createQuery(update).executeUpdate();
    }

}

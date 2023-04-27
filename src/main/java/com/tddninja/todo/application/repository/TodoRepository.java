package com.tddninja.todo.application.repository;

import com.tddninja.todo.application.entity.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long>, CustomTodoRepository {

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update Todo t set t.title = :title where t.id = :id")
    void updateTitle(@Param(value = "id") long id, @Param(value = "title") String title);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update Todo t set t.description = :description where t.id = :id")
    void updateDescription(@Param(value = "id") long id, @Param(value = "description") String description);

}

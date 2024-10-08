package org.example.expert.domain.todo.impl;

import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepositoryQuery {

    Optional<Todo> findByIdWithUser(Long todoId);
    Page<TodoSearchResponse> searchTodos(String keyword, LocalDateTime startDate, LocalDateTime endDate, String ownerNickname, Pageable pageable);
}

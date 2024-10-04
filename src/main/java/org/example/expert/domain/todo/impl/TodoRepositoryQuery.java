package org.example.expert.domain.todo.impl;

import org.example.expert.domain.todo.entity.Todo;

import java.util.Optional;

public interface TodoRepositoryQuery {

    Optional<Todo> findByIdWithUser(Long todoId);
}

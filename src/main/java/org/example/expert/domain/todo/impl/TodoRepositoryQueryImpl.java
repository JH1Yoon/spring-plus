package org.example.expert.domain.todo.impl;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TodoRepositoryQueryImpl implements TodoRepositoryQuery{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {
        QTodo todo = QTodo.todo;
        Todo result = jpaQueryFactory
                .selectFrom(todo)
                .leftJoin(todo.user).fetchJoin() // N+1 문제 해결
                .where(todo.id.eq(todoId))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public Page<TodoSearchResponse> searchTodos(String keyword, LocalDateTime startDate, LocalDateTime endDate, String ownerNickname, Pageable pageable) {
        QTodo todo = QTodo.todo;
        QUser user = QUser.user;

        QueryResults<TodoSearchResponse> results = jpaQueryFactory
                .select(Projections.constructor(TodoSearchResponse.class,
                        todo.title,
                        user.count().longValue(),
                        todo.comments.size().longValue()
                ))
                .from(todo)
                .leftJoin(todo.user, user)
                .leftJoin(todo.comments)
                .where(
                        keyword != null ? todo.title.containsIgnoreCase(keyword) : null,
                        startDate != null ? todo.createdAt.goe(startDate) : null,
                        endDate != null ? todo.createdAt.loe(endDate) : null,
                        ownerNickname != null ? user.nickname.containsIgnoreCase(ownerNickname) : null
                )
                .groupBy(todo.id)
                .orderBy(todo.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<TodoSearchResponse> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}

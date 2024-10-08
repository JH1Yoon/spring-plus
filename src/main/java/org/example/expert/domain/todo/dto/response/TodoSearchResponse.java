package org.example.expert.domain.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class TodoSearchResponse {
    private String title;
    private Long managerCount;
    private Long commentCount;
}

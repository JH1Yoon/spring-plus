package org.example.expert.domain.log.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "log")
public class Log{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private Long userId;
    private String status;
    private String message;

    private LocalDateTime createdAt;

    public Log(Long userId, String action, String status, String message) {
        this.userId = userId;
        this.action = action;
        this.status = status;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }
}

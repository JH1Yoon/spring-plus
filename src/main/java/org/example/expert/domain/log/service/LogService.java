package org.example.expert.domain.log.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.expert.domain.log.entity.Log;
import org.example.expert.domain.log.repository.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(String action, Long userId, String status, String message) {
        try {
            Log logEntry = new Log(userId, action, status, message);
            logRepository.save(logEntry);
        } catch (Exception e) {
            log.error("로그 저장 실패: {}", e.getMessage(), e);
        }
    }
}
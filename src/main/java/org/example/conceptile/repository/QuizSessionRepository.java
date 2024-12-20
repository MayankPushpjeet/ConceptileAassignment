package org.example.conceptile.repository;

import org.example.conceptile.model.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
    List<QuizSession> findByUsername(String username);
}

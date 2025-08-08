package com.example.demo.repository;
import com.example.demo.Model.messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface ChatMessageRepository extends JpaRepository<messages, Long> {
    List<messages> findTop20ByOrderByTimestampDesc();
}
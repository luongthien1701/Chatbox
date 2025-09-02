package com.example.demo.repository;
import com.example.demo.Model.messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
public interface ChatMessageRepository extends JpaRepository<messages, Long> {
	@Query(
			  value = "SELECT * FROM (SELECT * FROM messages m WHERE m.conversation_id = :conversationId ORDER BY m.timestamp DESC LIMIT 20) sub ORDER BY sub.timestamp ASC;",
			  nativeQuery = true
			)
	List<messages> findTop20ByOrderByTimestampDesc(@Param("conversationId") Integer conversationId);
    
}
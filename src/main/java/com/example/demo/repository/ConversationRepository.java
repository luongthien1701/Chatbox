package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Conversation;

import java.util.List;
import java.util.Optional;
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
	Optional<Conversation> findByConversationId(Integer conversationId);
}
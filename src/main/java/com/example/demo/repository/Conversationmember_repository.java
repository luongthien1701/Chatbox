package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Acount;
import com.example.demo.Model.Conversation;
import com.example.demo.Model.ConversationMember;

public interface Conversationmember_repository extends JpaRepository<ConversationMember,Integer>
{
	public interface ConversationSummary {
	    Integer getConversationId();
	    String getName();
	}

	@Query("""
	    SELECT c.conversationId AS conversationId, c.name AS name
	    FROM Conversation c
	    JOIN c.members m
	    WHERE m.user.userId = :userId
	""")
	List<ConversationSummary> findConversationSummaries(@Param("userId") Integer userId);
	
	Optional<ConversationMember> findByConversationAndUser(Conversation conversation,Acount user);
}

package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.repository.Conversationmember_repository.ConversationSummary;
import com.example.demo.Model.*;
import java.util.*;
@Service
public class ConversationService {
	@Autowired
	private Conversationmember_repository cm;
	public List<ConversationSummary> getUserConversation(int user_id)
	{
		return cm.findConversationSummaries(user_id);
	}
}

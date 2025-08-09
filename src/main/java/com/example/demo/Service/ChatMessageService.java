package com.example.demo.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Service;
import com.example.demo.Model.messages;
import com.example.demo.Model.Acount;
import com.example.demo.Model.Conversation;
import com.example.demo.repository.ChatMessageRepository;
import com.example.demo.repository.AcountRepository;
import com.example.demo.repository.ConversationRepository;
import com.example.demo.dto.MessageDTO;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository repo;
    
    @Autowired
    private AcountRepository acountRepository;
    
    @Autowired
    private ConversationRepository conversationRepository;

    public void saveMessage(int sender, String msg) {
        try {
            // Kiểm tra user có tồn tại không
            Acount user = acountRepository.findById(sender).orElse(null);
            if (user == null) {
                throw new IllegalArgumentException("User not found with ID: " + sender);
            }
            
            // Kiểm tra conversation có tồn tại không
            Conversation conversation = conversationRepository.findById(1).orElse(null);
            if (conversation == null) {
                throw new IllegalArgumentException("Conversation not found with ID: 1");
            }
            
            messages chat = new messages();
            chat.setUser(user);
            chat.setContext(msg);
            chat.setConversation(conversation);
            chat.settimestamp(LocalDateTime.now());
            
            repo.save(chat);
        } catch (Exception e) {
            // Log lỗi thay vì throw exception
            System.err.println("Error saving message: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<MessageDTO> getRecentMessages() {
        try {
            List<messages> latest = repo.findTop20ByOrderByTimestampDesc();
            Collections.reverse(latest);
            
            // Convert to DTO to avoid circular reference
            return latest.stream()
                .map(msg -> new MessageDTO(
                    msg.getMessagesId(),
                    msg.getContext(),
                    msg.gettimestamp(),
                    msg.getUser() != null ? msg.getUser().getDisplayName() : "Unknown",
                    msg.getUser() != null ? msg.getUser().getUserId() : null,
                    msg.getConversation() != null ? msg.getConversation().getConversationId() : null
                ))
                .collect(Collectors.toList());
        } catch (Exception e) {
            // Log lỗi và trả về list rỗng thay vì throw exception
            System.err.println("Error getting recent messages: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

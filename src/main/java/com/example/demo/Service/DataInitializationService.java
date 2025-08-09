package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Conversation;
import com.example.demo.repository.ConversationRepository;

@Service
public class DataInitializationService implements CommandLineRunner {

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public void run(String... args) throws Exception {
        // Khởi tạo conversation mặc định nếu chưa có
        if (!conversationRepository.existsById(1)) {
            Conversation defaultConversation = new Conversation();
            defaultConversation.setConversationId(1);
            defaultConversation.setName("Default Chat Room");
            conversationRepository.save(defaultConversation);
            System.out.println("Created default conversation with ID: 1");
        }
    }
} 
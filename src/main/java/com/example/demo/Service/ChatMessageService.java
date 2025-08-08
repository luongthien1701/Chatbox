package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.messages;
import com.example.demo.Model.Acount;

import com.example.demo.repository.ChatMessageRepository;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository repo;

    public void saveMessage(int sender, String msg) {
        Acount user = new Acount();
        user.setUserId(sender); 
        messages chat = new messages();
        chat.setUser(user);
        chat.setContext(msg);
        repo.save(chat);
    }
    public List<messages> getRecentMessages() {
        return repo.findTop20ByOrderByTimestampDesc();
    }
}

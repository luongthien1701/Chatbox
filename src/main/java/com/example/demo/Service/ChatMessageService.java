package com.example.demo.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Service;
import com.example.demo.Model.messages;
import com.example.demo.Model.Acount;
import com.example.demo.Model.Conversation;
import com.example.demo.repository.ChatMessageRepository;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository repo;

    public void saveMessage(int sender, String msg) {
        Acount user = new Acount();
        user.setUserId(sender); 
        messages chat = new messages();
        Conversation con=new Conversation();
        con.setConversationId(1);
        chat.setUser(user);
        chat.setContext(msg);
        chat.setConversation(con);
        Date date=new Date(0);
        chat.settimestamp(LocalDateTime.now());
        repo.save(chat);
    }
    public List<messages> getRecentMessages() {
        List<messages> latest = repo.findTop20ByOrderByTimestampDesc();
        Collections.reverse(latest);
        return latest;
    }
}

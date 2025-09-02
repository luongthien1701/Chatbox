package com.example.demo.Model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messages_id")
    private Integer messagesId;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    @JsonIgnoreProperties({"messeges", "members"}) 
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("conversationMembers")
    private Acount user;

    private String context;
    private LocalDateTime timestamp;

    public Integer getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(Integer messagesId) {
        this.messagesId = messagesId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Acount getUser() {
        return user;
    }

    public void setUser(Acount user) {
        this.user = user;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime gettimestamp() {
        return timestamp;
    }

    public void settimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

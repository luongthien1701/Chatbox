package com.example.demo.Model;


import java.sql.Date;

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
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Acount user;

    private String context;
    private Date timestamp;

    // Getters and setters
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
    public Date gettimestamp() {
        return timestamp;
    }

    public void settimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

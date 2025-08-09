package com.example.demo.dto;

import java.time.LocalDateTime;

public class MessageDTO {
    private Integer messagesId;
    private String context;
    private LocalDateTime timestamp;
    private String senderName;
    private Integer senderId;
    private Integer conversationId;

    public MessageDTO() {}

    public MessageDTO(Integer messagesId, String context, LocalDateTime timestamp, 
                     String senderName, Integer senderId, Integer conversationId) {
        this.messagesId = messagesId;
        this.context = context;
        this.timestamp = timestamp;
        this.senderName = senderName;
        this.senderId = senderId;
        this.conversationId = conversationId;
    }

    // Getters and setters
    public Integer getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(Integer messagesId) {
        this.messagesId = messagesId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }
} 
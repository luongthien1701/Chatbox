package com.example.demo.Model;

public class AddMemberRequest {
    private Integer conversationId;
    private Integer userId;

    public AddMemberRequest() {
    }

    public AddMemberRequest(Integer conversationId, Integer userId) {
        this.conversationId = conversationId;
        this.userId = userId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AddMemberRequest{" +
                "conversationId=" + conversationId +
                ", userId=" + userId +
                '}';
    }
}
package com.example.demo.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "conversation_member")
public class ConversationMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversation_member_id")
    private Integer conversationMemberId;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    @JsonIgnoreProperties({"members", "messeges"})
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("conversationMembers") 
    private Acount user;

    public Integer getConversationMemberId() {
        return conversationMemberId;
    }

    public void setConversationMemberId(Integer conversationMemberId) {
        this.conversationMemberId = conversationMemberId;
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
}

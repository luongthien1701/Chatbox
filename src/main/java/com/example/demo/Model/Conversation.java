package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversation_id")
    private Integer conversationId;

    private String name;

    @OneToMany(mappedBy = "conversation")
    @JsonIgnoreProperties("conversation") // Tránh vòng lặp khi serialize ConversationMember
    private List<ConversationMember> members;

    @OneToMany(mappedBy = "conversation")
    @JsonIgnoreProperties("conversation") // Tránh vòng lặp khi serialize messages
    private List<messages> messeges;

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConversationMember> getMembers() {
        return members;
    }

    public void setMembers(List<ConversationMember> members) {
        this.members = members;
    }

    public List<messages> getmesseges() {
        return messeges;
    }

    public void setmesseges(List<messages> messeges) {
        this.messeges = messeges;
    }
}

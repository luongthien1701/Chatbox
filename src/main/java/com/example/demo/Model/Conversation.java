package com.example.demo.Model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversation_id")
    private Integer conversationId;

    private String name;

    @OneToMany(mappedBy = "conversation")
    private List<ConversationMember> members;

    @OneToMany(mappedBy = "conversation")
    private List<messages> messeges;

    // Getters and setters
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

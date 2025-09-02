package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "acount")
public class Acount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String username;
    private String password;

    @Column(name = "display_name")
    private String displayName;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user") // Tránh vòng lặp khi serialize ConversationMember
    private List<ConversationMember> conversationMembers;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<ConversationMember> getConversationMembers() {
        return conversationMembers;
    }

    public void setConversationMembers(List<ConversationMember> conversationMembers) {
        this.conversationMembers = conversationMembers;
    }

}

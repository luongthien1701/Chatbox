package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.AddMemberRequest;
import com.example.demo.Model.Conversation;
import com.example.demo.Model.ConversationMember;
import com.example.demo.Model.Acount; // nếu class tên Account thì đổi lại cho đúng
import com.example.demo.Service.ConversationService;
import com.example.demo.repository.ConversationRepository;
import com.example.demo.repository.Conversationmember_repository;
import com.example.demo.repository.AcountRepository;
import com.example.demo.repository.Conversationmember_repository.ConversationSummary;

@RestController
@RequestMapping("/api")
public class ConversationController {

    @Autowired 
    private ConversationService cms;

    @Autowired 
    private ConversationRepository conversationRepository;

    @Autowired
    private AcountRepository acountRepository;

    @Autowired
    private Conversationmember_repository conversationMemberRepository;

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<ConversationSummary>> getUserConversations(@PathVariable int user_id) {
        return ResponseEntity.ok(cms.getUserConversation(user_id));
    }

    @PostMapping("/member/add")
    public ResponseEntity<?> addMember(@RequestBody AddMemberRequest request) {
        Conversation conversation = conversationRepository.findByConversationId(request.getConversationId())
                .orElseThrow(() -> new RuntimeException("Conversation not found"));

        Acount user = acountRepository.findByuserId(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<ConversationMember> existing =
                conversationMemberRepository.findByConversationAndUser(conversation, user);

        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("User already in this conversation");
        }

        ConversationMember cm = new ConversationMember();
        cm.setConversation(conversation);
        cm.setUser(user);

        conversationMemberRepository.save(cm);

        return ResponseEntity.ok("Member added successfully");
    }
}

package com.example.demo.Controller;

import com.example.demo.Model.messages;
import com.example.demo.Service.ChatMessageService;
import com.example.demo.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class msgController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/recent")
    public ResponseEntity<?> getRecentMessages() {
        try {
            List<MessageDTO> messages = chatMessageService.getRecentMessages();
            return ResponseEntity.ok(messages);
        } catch (Exception e) {
            // Log lỗi
            System.err.println("Error in getRecentMessages: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal server error");
        }
    }
}

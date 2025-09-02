package com.example.demo.Controller;

import com.example.demo.Model.messages;
import com.example.demo.Service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class msgController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/recent/{conversationId}")
    public List<messages> getRecentMessages(@PathVariable int conversationId) {
        return chatMessageService.getRecentMessages(conversationId);
    }
}

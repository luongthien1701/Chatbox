package com.example.demo.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.example.demo.Service.ChatMessageService;

public class TcpChatHandler extends Thread {
    private Socket socket;
    private ChatMessageService service;

    public TcpChatHandler(Socket socket, ChatMessageService service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String input;
            while ((input = in.readLine()) != null) {
                String[] parts = input.split(":", 2);
                if (parts.length == 2) {
                    String sender = parts[0].trim();
                    String message = parts[1].trim();
                    service.getRecentMessages();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

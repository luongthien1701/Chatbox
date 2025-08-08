package com.example.demo.Socket;

import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Service.ChatMessageService;

@Component
public class ChatServer implements CommandLineRunner {
    @Autowired
    private ChatMessageService service;

    private final int PORT = 5500;

    @Override
    public void run(String... args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new TcpChatHandler(clientSocket, service).start();
        }
    }
}


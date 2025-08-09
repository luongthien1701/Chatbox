package com.example.demo.Socket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Service.ChatMessageService;
import com.example.demo.repository.AcountRepository;

@Component
public class ChatServer implements CommandLineRunner {

    @Autowired
    private ChatMessageService service;

    @Autowired
    private AcountRepository acountRepository;

    private final int PORT = 5500;

    // Danh sách các client đang kết nối
    private final Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void run(String... args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Truyền đủ 4 tham số cho TcpChatHandler
                new TcpChatHandler(
                        clientSocket,
                        service,
                        clientWriters,
                        acountRepository
                ).start();
            }
        }
    }
}

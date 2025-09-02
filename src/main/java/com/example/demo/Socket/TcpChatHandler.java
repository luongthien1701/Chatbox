package com.example.demo.Socket;

import java.io.*;
import java.net.Socket;
import java.util.Optional;
import java.util.Set;

import com.example.demo.Model.Acount;
import com.example.demo.Service.ChatMessageService;
import com.example.demo.repository.AcountRepository;

public class TcpChatHandler extends Thread {
    private final Socket socket;
    private final ChatMessageService service;
    private final Set<PrintWriter> clientWriters;
    private final AcountRepository acountRepository;

    // Constructor injection
    public TcpChatHandler(Socket socket,
                          ChatMessageService service,
                          Set<PrintWriter> clientWriters,
                          AcountRepository acountRepository) {
        this.socket = socket;
        this.service = service;
        this.clientWriters = clientWriters;
        this.acountRepository = acountRepository;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            clientWriters.add(out);

            String input;
            while ((input = in.readLine()) != null) {
                String[] parts = input.split(":", 3);
                if (parts.length == 3) {
                	int conversation=Integer.parseInt(parts[0]);
                    String senderStr = parts[1].trim();
                    String message = parts[2].trim();

                    Optional<Acount> userOpt = acountRepository.findByDisplayName(senderStr);
                    if (userOpt.isPresent()) {
                        Acount user = userOpt.get();
                        service.saveMessage(conversation,user.getUserId(), message);

                        synchronized (clientWriters) {
                            for (PrintWriter writer : clientWriters) {
                                writer.println(senderStr + ": " + message);
                            }
                        }
                    } else {
                        out.println("User not found: " + senderStr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientWriters.removeIf(PrintWriter::checkError);
        }
    }
}
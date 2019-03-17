package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpChatServer implements ChatServer {
    private ServerSocket serverSocket;
    private List<Socket> onlineUsers = new ArrayList<>();
    private Thread acceptingThread;

    @Override
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.printf("Server is running on port %d...\n", port);
            acceptingThread = new Thread(this::startAcceptingClients);
            acceptingThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startAcceptingClients() {
        while(isOnline()) {
            try {
                Socket client = serverSocket.accept();
                onlineUsers.add(client);
                System.out.println("New client has joined. Online users: " + onlineUsers.size());
            } catch (IOException e) {
                // Ignored on purpose
            }
        }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public boolean isOnline() {
        return serverSocket != null && !serverSocket.isClosed();
    }
}
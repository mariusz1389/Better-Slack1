package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpChatServer implements ChatServer {
    private ServerSocket serverSocket;
    private List<ChatClient> onlineUsers = new ArrayList<>();
    private Thread acceptingThread;

    @Override
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Server is running on port %d...\n", port);
        acceptingThread = new Thread(this::startAcceptingClients);
        acceptingThread.start();
    }

    private void startAcceptingClients() {
        while(isOnline()) {
            try {
                Socket clientSocket = serverSocket.accept();
                ChatClient client = new TcpChatClient(clientSocket);
                client.subscribe(this);
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

    @Override
    public void clientDisconnected(ChatClient client) {
        onlineUsers.remove(client);
        System.out.println("Client left the building. Clients online: " + onlineUsers.size());
    }
}
package Sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SampleServerContinuousReading {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader clientInput;

    private static final String EXIT_KEYWORD = "exit";

    public void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running...");
        clientSocket = serverSocket.accept();
        System.out.println("Client has been connected");

        clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while(!clientSocket.isClosed()) {
            String receivedMessage = "";

            try {
                receivedMessage = clientInput.readLine();
            } catch(SocketException ex) {
                System.out.println("Client has been disconnected");
                break;
            }

            if(receivedMessage.toLowerCase().equals(EXIT_KEYWORD)) {
                break;
            }

            System.out.println(receivedMessage);
        }
    }
}
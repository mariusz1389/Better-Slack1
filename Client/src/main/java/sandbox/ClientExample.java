package sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {

    private static final String EXIT_KEYWORD = "Exit";
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    public void connectToServer(String ipAddress, int port) throws IOException {
        Scanner scanner = new Scanner(System.in);

        socket = new Socket(ipAddress, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.toLowerCase().equals(EXIT_KEYWORD)){
                break;
            }
            output.println(userInput);
        }


    }
}

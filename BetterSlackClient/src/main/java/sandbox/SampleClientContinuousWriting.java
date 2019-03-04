package sandbox;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SampleClientContinuousWriting {
    private Socket socket;
    private PrintWriter output;

    private static final String EXIT_KEYWORD = "exit";

    public void connectToServer(String ipAddress, int port) throws IOException {
        socket = new Socket(ipAddress, port);
        output = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String userInput = scanner.next();
            output.println(userInput);

            if(userInput.toLowerCase().equals(EXIT_KEYWORD)) {
                break;
            }
        }
    }
}

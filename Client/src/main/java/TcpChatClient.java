import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpChatClient implements NetworkBasedChatClient {
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    private Thread readerThread;

    @Override
    public void connect(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            startReading();
        } catch (IOException e) {
            throw new IllegalStateException("Could not connect to the server at: " +
                    ip + ":" + port);
        }
    }

    private void startReading() {
        readerThread = new Thread(() -> {
            while (isOnline()) {
                readMessage();
            }
            System.out.println("Lost connect with the server.");
        });
        readerThread.start();
    }

    private void readMessage() {
        try {
            String msg = input.readLine();

            if(msg == null) {
                disconnect();
                return;
            }

            System.out.println(msg);
        } catch (IOException e) {
            // TBD
        }
    }

    @Override
    public void disconnect() {
        if(isOnline()) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // No implementation needed
            }
            clientSocket = null;
        }
    }

    @Override
    public void sendMessage(String message) {
        if(isOnline() && !message.trim().isEmpty()) {
            output.println(message);
        }
    }

    @Override
    public boolean isOnline() {
        return clientSocket != null &&
                !clientSocket.isClosed();
    }
}

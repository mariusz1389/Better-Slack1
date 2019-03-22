import network.ChatServer;
import network.TcpChatServer;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new TcpChatServer();
        chatServer.start(50000);
    }
}

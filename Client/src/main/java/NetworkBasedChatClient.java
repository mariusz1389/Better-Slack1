import java.io.IOException;

public interface NetworkBasedChatClient extends ChatClient {

    void sendMessage(String message);

    void connect (String ip, int port) throws IOException;

    void disconnect ();

    boolean isOnline();


}

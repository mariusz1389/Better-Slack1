package network;

public interface ChatServer {

    void start(int port);

    void shutdown();

    boolean isOnline();

}

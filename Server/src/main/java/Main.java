import network.ChannelRepository;
import network.ChatServer;
import network.InMemoryChannelRepository;
import network.TcpChatServer;
import utils.BetterSlackInitializer;
import utils.DefaultInitializer;

public class Main {
    public static void main(String[] args) {
        ChannelRepository channelRepository = new InMemoryChannelRepository();
        BetterSlackInitializer initializer =new DefaultInitializer(channelRepository);
        initializer.initialize();
        ChatServer chatServer = new TcpChatServer(channelRepository);
        chatServer.start(50000);
    }
}

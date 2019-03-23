package network;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PublicChannel extends Channel {
    private List<ChatClient> channelClients = new ArrayList<>();

    public PublicChannel(String name) {
        super(name);
    }

    @Override
    public void join(ChatClient client) {
        channelClients.add(client);
    }

    @Override
    public void broadcast(ChatClient sender, String message) {
        List<ChatClient> recipients = channelClients.stream()
                .filter(chatClient -> chatClient != sender)
                .collect(Collectors.toList());

        recipients.forEach(recipient -> recipient.sendMessage(message));
    }

    @Override
    public void leave(ChatClient client) {
        channelClients.remove(client);
    }
}
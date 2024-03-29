package network;

import jdk.nashorn.internal.runtime.options.Option;
import settings.ChannelSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TcpChatClient implements ChatClient {
    private final Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    private Thread readerThread;
    private String currentChannelName = ChannelSettings.DEFAULT_CHANNEL_NAME;
    private final ChannelRepository channelRepository;

    private final List<DisconnectObserver> disconnectObservers = new ArrayList<>();

    public TcpChatClient(Socket clientSocket, ChannelRepository channelRepository) {
        this.clientSocket = clientSocket;
        try {
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
        } catch (IOException e) {
            throw new IllegalStateException("Error initializing client");
        }
        this.channelRepository = channelRepository;
        startReading();
    }

    private void startReading() {
        readerThread = new Thread(() -> {
            while (isOnline()) {
                readMessage();
            }
            notifyDisconnected(this);
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
            channelRepository.findByName(currentChannelName)
                    .ifPresent(channel -> channel.broadcast(this, msg));
        } catch (IOException e) {
            disconnect();
        }
    }

    @Override
    public void sendMessage(String message) {
        if(isOnline()) {
            output.println(message);
        }
    }

    @Override
    public void disconnect() {
        if(isOnline()) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // Unhandled intentionally
            }
        }
    }

    @Override
    public boolean isOnline() {
        return clientSocket != null && !clientSocket.isClosed();
    }

    @Override
    public void changeCurrentChannel(String channelName) {
        if(!channelName.equals(currentChannelName)) {
            channelRepository.findByName(channelName)
                    .orElseThrow(() -> new IllegalStateException("Channel does not exist"));
            currentChannelName = channelName;
        }
    }

    @Override
    public String getCurrentChannelName() {
        return null;
    }

    @Override
    public void subscribe(DisconnectObserver observer) {
        disconnectObservers.add(observer);
    }

    @Override
    public void unsubscribe(DisconnectObserver observer) {
        disconnectObservers.remove(observer);
    }

    @Override
    public void notifyDisconnected(ChatClient chatClient) {
        for(DisconnectObserver observer : disconnectObservers) {
            observer.clientDisconnected(chatClient);
        }
    }
}
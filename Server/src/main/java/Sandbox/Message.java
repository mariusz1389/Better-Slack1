package Sandbox;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Message {
    private LocalDateTime timestamp;
    private String content;

    /**
     * Used by frameworks
     */
    private Message() {
    }

    public Message(String content) {
        timestamp = LocalDateTime.now();
        this.content = content;
    }

    public Message(LocalDateTime timestamp, String content) {
        this.timestamp = timestamp;
        this.content = content;
    }
}

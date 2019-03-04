import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BetterSlackError {
    private LocalDateTime timestamp;
    private String message;

    /**
     * Constructor for serialization
     * and various frameworks
     */
    public BetterSlackError() {
    }

    public BetterSlackError(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}

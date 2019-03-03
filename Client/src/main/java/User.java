import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter

public class User {
    private static final int MIN_USERNAME_LENGTH = 4;
    private static final int MAX_USERNAME_LENGTH = 20;


    private UUID id;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public User(String userName, String password) {
        id = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    public void changeUserName(String userName) {
        if (!isUSernameValid(userName)) {
            throw new IllegalArgumentException("Valid username should have " +
                    "a length between" + MIN_USERNAME_LENGTH +
                    " and " +MAX_USERNAME_LENGTH);

        }
        this.userName = userName;
        update();

    }


    private boolean isUSernameValid(String userName) {
        return userName != null &&
                userName.length() >= MIN_USERNAME_LENGTH &&
                userName.length() <= MAX_USERNAME_LENGTH;

    }

    private void update (){
        updatedAt = LocalDateTime.now();
    }
}

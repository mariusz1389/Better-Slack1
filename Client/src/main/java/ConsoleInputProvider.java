import exceptions.EmptyMessageException;

import java.util.Scanner;

public class ConsoleInputProvider implements UserInputProvider {
    private final Scanner scanner = new Scanner(System.in);
    private final String username;

    public ConsoleInputProvider() {
        String tempUsername;
        while(true) {
            System.out.print("Enter username: ");
            tempUsername = scanner.nextLine();

            if(isUsernameValid(tempUsername))
                break;
        }
        username = tempUsername;
    }

    @Override
    public String getUserInput() {
        String input = scanner.nextLine();

        if(input.trim().isEmpty()) {
            throw new EmptyMessageException();
        }

        return String.format("%s: %s", username, input);
    }

    private static boolean isUsernameValid(String username) {
        return !username.isEmpty() &&
                username.length() >= UserSettings.MIN_USERNAME_LENGTH &&
                username.length() < UserSettings.MAX_USERNAME_LENGTH &&
                username.matches(UserSettings.USERNAME_PATTERN);
    }
}
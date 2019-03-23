import java.util.Scanner;

public class ConsoleInputProvider implements UserInputProvider {
    private final Scanner scanner = new Scanner(System.in);
    private final String username;

    public ConsoleInputProvider() {
        String tempUsername;
        while(true) {
            System.out.print("Enter username");
            tempUsername = scanner.nextLine();

            if(isUsernameValid(tempUsername))
                break;
        }
        username = tempUsername;
    }

    @Override
    public String getUserInput() {
        return String.format("%s: %s", username, scanner.nextLine());
    }

    private static boolean isUsernameValid(String username) {
        return !username.isEmpty() &&
                username.length() >= 2 &&
                username.length() < 15;
    }
}
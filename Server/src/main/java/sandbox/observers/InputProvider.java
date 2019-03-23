package sandbox.observers;

import java.util.Scanner;

public class InputProvider {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        String input = scanner.nextLine();
        return input;
    }
}
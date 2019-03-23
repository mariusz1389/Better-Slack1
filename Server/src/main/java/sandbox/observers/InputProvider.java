package sandbox.observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputProvider implements TerminationObservable {
    private final Scanner scanner = new Scanner(System.in);
    private final List<ExitExecutionObserver> terminationObservers = new ArrayList<>();

    public String getInput() {
        String input = scanner.nextLine();

        if(input.equals("q")) {
            notifyObservers();
        }

        return input;
    }

    @Override
    public void subscribe(ExitExecutionObserver observer) {
        terminationObservers.add(observer);
    }

    @Override
    public void unsubscribe(ExitExecutionObserver observer) {
        terminationObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        terminationObservers.forEach(observer -> observer.exitRequested());
    }
}
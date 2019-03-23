package sandbox.observers;

public interface TerminationObservable {
    void subscribe(ExitExecutionObserver observer);
    void unsubscribe(ExitExecutionObserver observer);
    void notifyObservers();

}

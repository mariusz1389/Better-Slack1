public class Greeter implements Runnable {
    private final String name;

    public Greeter(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Hello from thread " + name);
    }
}
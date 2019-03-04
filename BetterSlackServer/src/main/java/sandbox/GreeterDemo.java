package sandbox;

public class GreeterDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Greeter("Thread1"));
        Thread thread2 = new Thread(new Greeter("Thread2"));
        thread1.start();
        thread2.start();

        int x = 5;

        Thread thread3 = new Thread(() -> {
            System.out.println("Hello from another thread: " + x);
        });
    }
}

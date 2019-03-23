package sandbox.observator;

public class CounterDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            int counter = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(++counter);
            }

        }).start();
    }
}

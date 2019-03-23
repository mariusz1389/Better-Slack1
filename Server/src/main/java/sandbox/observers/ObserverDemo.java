package sandbox.observers;


    public class ObserverDemo {
        public static void main(String[] args) throws InterruptedException {
            InputProvider inputProvider = new InputProvider();
            MyTimer myTimer = new MyTimer();
            myTimer.start();
            while (true) {
                String input = inputProvider.getInput();

                if(input.equals("q")) {
                    break;
                }

                System.out.println(input);
            }
            myTimer.join();
            System.out.println("Main thread exited");
        }

    }


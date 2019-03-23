package Sandbox.observator;

import java.util.Scanner;

public class TimerDemo {

    private static String EXIT_KEYWORD = "exit";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            System.out.println(input);
        }
    }


//        Scanner scanner = new Scanner(System.in);
//
//
//
//        while (true) {
//            String message = scanner.nextLine();
//            if (message.equals(EXIT_KEYWORD)){
//                System.out.println("user hes left the building");
//                break;
//            } else {
//                System.out.println(message);
//                String userInput = scanner.nextLine();
//                message = userInput;
//            }
//
//        }
//        System.out.println("end of programm");


}


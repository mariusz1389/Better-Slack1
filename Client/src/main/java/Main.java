import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        NetworkBasedChatClient client = new TcpChatClient();

        client.connect("localhost", 50000);

        UserInputProvider inputProvider = new ConsoleInputProvider();
        while (client.isOnline()){
            String userInput = inputProvider.getUserInput();
            client.sendMessage(userInput);
        }



    }
}

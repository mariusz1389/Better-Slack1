import java.io.IOException;

public class ClientTestClass {

    public static void main(String[] args) throws IOException {

        ClientExample clientExample = new ClientExample();

        clientExample.connectToServer("localhost",60000);
    }
}

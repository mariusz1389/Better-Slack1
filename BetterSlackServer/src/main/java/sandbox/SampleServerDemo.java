package sandbox;

import java.io.IOException;

public class SampleServerDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        SampleServerAsyncAccept sampleServerAsyncAccept = new SampleServerAsyncAccept();
        sampleServerAsyncAccept.startServer(55555);
        Thread.sleep(5000);
        sampleServerAsyncAccept.shutdown();
    }
}

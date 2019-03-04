package sandbox;

import java.io.IOException;

public class SampleClientDemo {
    public static void main(String[] args) throws IOException {
        SampleClientContinuousWriting sampleClientContinuousWriting = new SampleClientContinuousWriting();
        sampleClientContinuousWriting.connectToServer("localhost", 55555);
    }
}

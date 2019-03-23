package sandbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        Message message = new Message("Hello");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        String serialized = objectMapper.writeValueAsString(message);
        System.out.println(serialized);

        Message deserializedMessage = objectMapper.readValue(serialized, Message.class);
        System.out.println(deserializedMessage.getContent());
        System.out.println(deserializedMessage.getTimestamp());
    }
}
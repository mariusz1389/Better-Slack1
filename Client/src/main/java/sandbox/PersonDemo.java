package sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PersonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("John", "Smith", 30);
        Purchase purchases = new Purchase("laptop", 5234.99);

        person.addPurchase(purchases);
        for (int i = 0; i < 3; i++) {
            person.addInteger(i + 1);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String dtoAsString = objectMapper.writeValueAsString(person);


        String serialized = objectMapper.writeValueAsString(person);
        System.out.println(serialized);


    }
}

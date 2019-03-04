package sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PersonSerializationDemo {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("John", "Smith", 30);
        Purchase purchase = new Purchase("laptop", 5234.99);
        person.addPurchase(purchase);

        for(int i = 0; i < 3; i++) {
            person.addInteger(i+1);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String serialized = mapper.writeValueAsString(person);
        System.out.println(serialized);
    }
}

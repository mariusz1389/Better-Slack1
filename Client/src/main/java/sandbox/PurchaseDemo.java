package sandbox;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PurchaseDemo {

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("John", "Smith", 30);
        Purchase purchases = new Purchase("laptop", 5234.99);

        person.addPurchase(purchases);
        person.addInteger(1);
        person.addInteger(2);
        person.addInteger(3);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String dtoAsString = objectMapper.writeValueAsString(person);


        String serialized = objectMapper.writeValueAsString(person);
        System.out.println(serialized);




    }

}

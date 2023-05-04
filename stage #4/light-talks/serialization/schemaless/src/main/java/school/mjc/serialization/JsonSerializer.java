package school.mjc.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonSerializer {

    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public byte[] serialize(User user) {
        try {
            return objectMapper.writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public AnotherUser deserialize(byte[] serialized) {
        try {
            return objectMapper.readValue(serialized, AnotherUser.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        JsonSerializer jsonSerializer = new JsonSerializer();

        byte[] serialized = jsonSerializer.serialize(UserProvider.getUser());
        System.out.println("User serialized = " + new String(serialized, StandardCharsets.UTF_8));
        System.out.println("User serialized length = " + serialized.length);

        AnotherUser anotherUser = jsonSerializer.deserialize(serialized);
        System.out.println("Deserialized = " + anotherUser);
    }
}

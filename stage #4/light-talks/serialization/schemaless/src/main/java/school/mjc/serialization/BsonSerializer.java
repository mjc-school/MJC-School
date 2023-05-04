package school.mjc.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BsonSerializer {

    private final ObjectMapper objectMapper;

    public BsonSerializer() {
        this.objectMapper = new ObjectMapper(new BsonFactory());
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
        BsonSerializer serializer = new BsonSerializer();

        byte[] serialized = serializer.serialize(UserProvider.getUser());
        System.out.println("User serialized = " + new String(serialized, StandardCharsets.UTF_8));
        System.out.println("User serialized: ");
        for (int i = 0; i < serialized.length; i++) {
            byte b = serialized[i];
            if (i == 0) {
                System.out.printf("\\x%02x ", b);
            } else if (isPrintableChar((char) b)) {
                System.out.print((char)b);
            } else {
                System.out.printf("\\x%02x ", b);
            }
        }
        System.out.println();
        System.out.println("User serialized length = " + serialized.length);

        AnotherUser deserialized = serializer.deserialize(serialized);
        System.out.println(deserialized);
    }

    public static boolean isPrintableChar( char c ) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of( c );
        return (!Character.isISOControl(c)) &&
            c != KeyEvent.CHAR_UNDEFINED &&
            block != null &&
            block != Character.UnicodeBlock.SPECIALS;
    }
}

package school.mjc.serialization;

import org.msgpack.MessagePack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static school.mjc.serialization.BsonSerializer.isPrintableChar;

// --add-opens=java.base/java.lang=ALL-UNNAMED
public class MsgPackSerializer {

    private final MessagePack msgPack = new MessagePack();

    public byte[] serialize(User user) {
        try {
            return msgPack.write(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AnotherUser deserialize(byte[] serialized) {
        try {
            return msgPack.read(serialized, AnotherUser.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MsgPackSerializer serializer = new MsgPackSerializer();

        byte[] serialized = serializer.serialize(UserProvider.getUser());
        System.out.println("User serialized = " + new String(serialized, StandardCharsets.UTF_8));
        System.out.println(Arrays.toString(serialized));
        System.out.println("User serialized length = " + serialized.length);

        var deserialize = serializer.deserialize(serialized);
        System.out.println(deserialize);
    }
}

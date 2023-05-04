package school.mjc.serialization;

import lombok.Data;
import lombok.experimental.Accessors;
import org.msgpack.annotation.Message;

@Data
@Accessors(chain = true)
@Message
public class Movie {

    public String name;
    public int year;
}

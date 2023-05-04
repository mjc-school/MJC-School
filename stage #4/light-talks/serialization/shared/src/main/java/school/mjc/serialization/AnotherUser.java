package school.mjc.serialization;

import lombok.Data;
import lombok.experimental.Accessors;
import org.msgpack.annotation.Message;

import java.util.List;

@Data
@Accessors(chain = true)
@Message
public class AnotherUser {

    public int id;
    private String name;
    private List<Movie> favouriteMovies;
}

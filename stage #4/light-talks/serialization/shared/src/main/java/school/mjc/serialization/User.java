package school.mjc.serialization;

import lombok.Data;
import lombok.experimental.Accessors;
import org.msgpack.annotation.Message;

import java.util.List;

@Data
@Accessors(chain = true)
@Message
public class User {

    public int id;
    public String name;
    public List<Movie> favouriteMovies;
}

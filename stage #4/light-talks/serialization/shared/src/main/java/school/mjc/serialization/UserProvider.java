package school.mjc.serialization;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UserProvider {

    public static User getUser() {
        Movie movie = new Movie()
            .setName("The Lord of the Rings: Return of the King")
            .setYear(2003);
        return new User()
            .setId(1)
            .setName("Danila Varatyntsev")
            .setFavouriteMovies(List.of(movie));
    }

    public static User getFatUser() {
        List<Movie> movies = IntStream.range(0, 100)
            .mapToObj(i -> new Movie()
                .setName("Movie name " + i)
                .setYear(i))
            .toList();
        return new User()
            .setId(1)
            .setName("Danila Varatyntsev")
            .setFavouriteMovies(movies);
    }
}

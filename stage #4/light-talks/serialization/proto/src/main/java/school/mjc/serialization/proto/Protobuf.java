package school.mjc.serialization.proto;

import com.google.protobuf.InvalidProtocolBufferException;
import school.mjc.UserOuterClass;
import school.mjc.another.AnotherUserOuterClass;
import school.mjc.serialization.AnotherUser;
import school.mjc.serialization.Movie;
import school.mjc.serialization.User;
import school.mjc.serialization.UserProvider;

import java.awt.image.BandCombineOp;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Protobuf {

    public byte[] serialize(User user) {
        UserOuterClass.User convertedUser = convertUser(user);

        return convertedUser.toByteArray();
    }

    public AnotherUser deserialize(byte[] serialized) {
        try {
            AnotherUserOuterClass.AnotherUser user =
                AnotherUserOuterClass.AnotherUser.parseFrom(serialized);
            return convertUser(user);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserOuterClass.User convertUser(User user) {
        UserOuterClass.User.Builder builder = UserOuterClass.User.newBuilder()
            .setId(user.getId())
            .setName(user.getName());

        for (Movie movie : user.getFavouriteMovies()) {
            UserOuterClass.Movie convertedMovie = UserOuterClass.Movie.newBuilder()
                .setName(movie.getName())
                .setYear(movie.getYear()).build();
            builder.addFavouriteMovies(convertedMovie);
        }

        return builder.build();
    }

    private static AnotherUser convertUser(AnotherUserOuterClass.AnotherUser user) {
        AnotherUser converted = new AnotherUser()
            .setId(user.getId())
            .setName(user.getName());

        List<Movie> movies = new ArrayList<>(user.getFavouriteMoviesCount());
        for (AnotherUserOuterClass.Movie movie : user.getFavouriteMoviesList()) {
            Movie convertedMovie = new Movie()
                .setName(movie.getName())
                .setYear(movie.getYear());
            movies.add(convertedMovie);
        }

        return converted.setFavouriteMovies(movies);
    }

    public static void main(String[] args) {
        Protobuf protobuf = new Protobuf();

        byte[] bytes = protobuf.serialize(UserProvider.getUser());

        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        System.out.println("Serialized message takes " + bytes.length + " bytes");

        AnotherUser deserialize = protobuf.deserialize(bytes);
        System.out.println(deserialize);
    }
}

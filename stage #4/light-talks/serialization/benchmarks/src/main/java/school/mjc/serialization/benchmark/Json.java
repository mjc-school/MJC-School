package school.mjc.serialization.benchmark;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import school.mjc.serialization.JsonSerializer;
import school.mjc.serialization.User;
import school.mjc.serialization.UserProvider;

import java.util.concurrent.TimeUnit;


public class Json {

    private static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    private static final User USER = UserProvider.getFatUser();
    private static final byte[] USER_STRING = JSON_SERIALIZER.serialize(USER);

    @Benchmark
    public void serialize(Blackhole bh) {
        bh.consume(JSON_SERIALIZER.serialize(USER));
    }

    @Benchmark
    public void deserialize(Blackhole bh) {
        bh.consume(JSON_SERIALIZER.deserialize(USER_STRING));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(Json.class.getSimpleName())
            .forks(1)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.MICROSECONDS)
            .warmupTime(TimeValue.seconds(5))
            .warmupIterations(2)
            .measurementIterations(2)
            .measurementTime(TimeValue.seconds(3))
            .build();

        new Runner(opt).run();
    }
}

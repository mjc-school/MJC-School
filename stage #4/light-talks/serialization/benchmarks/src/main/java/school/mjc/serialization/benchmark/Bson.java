package school.mjc.serialization.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import school.mjc.serialization.BsonSerializer;
import school.mjc.serialization.User;
import school.mjc.serialization.UserProvider;

import java.util.concurrent.TimeUnit;


public class Bson {

    private static final BsonSerializer SERIALIZER = new BsonSerializer();

    private static final User USER = UserProvider.getFatUser();
    private static final byte[] USER_STRING = SERIALIZER.serialize(USER);

    @Benchmark
    public void serialize(Blackhole bh) {
        bh.consume(SERIALIZER.serialize(USER));
    }

    @Benchmark
    public void deserialize(Blackhole bh) {
        bh.consume(SERIALIZER.deserialize(USER_STRING));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(Bson.class.getSimpleName())
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

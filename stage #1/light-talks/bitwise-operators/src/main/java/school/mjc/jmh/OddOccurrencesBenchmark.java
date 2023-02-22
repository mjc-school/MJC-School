package school.mjc.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import school.mjc.bitwise.OddOccurrences;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class OddOccurrencesBenchmark {

    @State(Scope.Benchmark)
    public static class ArrayContainer {

        @Param({ "1", "2", "3"})
        int arrayIndex;

        int [] array;

        @Setup(Level.Trial)
        public void initArray() {
            array = switch (arrayIndex) {
                case 1 -> new int[]{1, 2, 3, 1, 2, 3, 1};
                case 2 -> new int[]{5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 2};
                case 3 -> new int[]{5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 2, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 2, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 2, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 2, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2, 5, 4, 2};
                default -> throw new RuntimeException();
            };
        }
    }

    @Benchmark
    public void map(Blackhole bh, ArrayContainer container) {
        bh.consume(OddOccurrences.map(container.array));
    }

    @Benchmark
    public void stream(Blackhole bh, ArrayContainer container) {
        bh.consume(OddOccurrences.stream(container.array));
    }

    @Benchmark
    public void xor(Blackhole bh, ArrayContainer container) {
        bh.consume(OddOccurrences.xor(container.array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(OddOccurrencesBenchmark.class.getSimpleName())
                .forks(1)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(5))
                .warmupIterations(1)
                .measurementIterations(1)
                .measurementTime(TimeValue.seconds(5))
                .build();

        new Runner(opt).run();
    }
}

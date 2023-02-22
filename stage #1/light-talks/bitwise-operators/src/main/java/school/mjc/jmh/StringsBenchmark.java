package school.mjc.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import school.mjc.bitwise.Strings;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class StringsBenchmark {

    @Param({"abcdefghijklmnopqrstuvwxyz",
            "abcdefghijklmnopqrstuvwxy",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcdefghijklmnopqrstuvwxyz"})
    private String string;

    @Benchmark
    public void naive(Blackhole bh) {
        bh.consume(Strings.naiveCycle(string));
    }

    @Benchmark
    public void array(Blackhole bh) {
        bh.consume(Strings.array(string));
    }

    @Benchmark
    public void arrayBoolean(Blackhole bh) {
        bh.consume(Strings.arrayBoolean(string));
    }

    @Benchmark
    public void bytes(Blackhole bh) {
        bh.consume(Strings.bytes(string));
    }
    @Benchmark
    public void bitSet(Blackhole bh) {
        bh.consume(Strings.bitSet(string));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringsBenchmark.class.getSimpleName())
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

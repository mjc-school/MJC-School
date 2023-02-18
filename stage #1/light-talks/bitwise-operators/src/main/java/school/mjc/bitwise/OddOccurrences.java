package school.mjc.bitwise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OddOccurrences {

    public int getNumberWithOddOccurrences(int[] array) {
        return map(array);
    }

    public static Integer map(int[] array) {
        var result = new HashMap<Integer, Integer>();
        for (int i : array) {
            result.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException();
    }

    public static Integer stream(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 == 1)
                .findAny()
                .orElseThrow()
                .getKey();
    }

    public static Integer xor(int[] array) {
        // Relies on the property that i^i=0
        // From this property, i^...^i even number of times = 0
        // And i^...^i odd number of times = i

        int result = 0;
        for (int i : array) {
            result ^= i;
        }
        return result;
    }
    
    //        (arrayIndex)  Mode  Cnt  Score   Error  Units
    //map                1  avgt       0.114          us/op
    //map                2  avgt       0.430          us/op
    //map                3  avgt       2.053          us/op
    //
    //stream             1  avgt       0.252          us/op
    //stream             2  avgt       0.786          us/op
    //stream             3  avgt       2.764          us/op
    //
    //xor                1  avgt       0.007          us/op
    //xor                2  avgt       0.013          us/op
    //xor                3  avgt       0.054          us/op
}

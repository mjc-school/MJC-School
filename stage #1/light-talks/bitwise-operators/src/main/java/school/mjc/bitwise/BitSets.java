package school.mjc.bitwise;

import java.util.BitSet;
import java.util.concurrent.ThreadLocalRandom;

public class BitSets {
    public static void main(String[] args) {
//        basic();
        userStatistics();
    }

    private static void basic() {
        BitSet bitSet1 = new BitSet();
        bitSet1.set(4);
        bitSet1.set(10);
        bitSet1.clear(5, 15);

        BitSet bitSet2 = new BitSet();
        bitSet2.set(3);

        bitSet1.or(bitSet2);
        System.out.println("Resulting bit set = " + bitSet1);
        System.out.println("Cardinality = " + bitSet1.cardinality());
    }

    public static void userStatistics() {
        BitSet monday = getDayStatistics();
        BitSet tuesday = getDayStatistics();

        // calculate, how many people logged in on Monday
        System.out.println(monday.cardinality());

        // calculate, how many people logged in on Monday or Tuesday
        tuesday.or(monday);
        System.out.println(tuesday.cardinality());
    }

    private static BitSet getDayStatistics() {
        // create bitSet for 1mil users
        // 1.000.000 / 8 bits per byte = 125Kb
        BitSet bitSet = new BitSet(1_000_000);

        // simulate 100k random events, for example logins
        for (int i = 0; i < 100_000; i++) {
            int userIndex = ThreadLocalRandom.current().nextInt(0, 1_000_000);
            bitSet.set(userIndex);
        }
        return bitSet;
    }
}

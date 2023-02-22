package school.mjc.bitwise;

/**
 * Determine if provided number is a power of 2
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int i) {
        return naive(i);
    }

    public boolean naive(int i) {
        int power = 1;
        while (true) {
            if (i == power) {
                return true;
            } else if (power < 0) {
                return false;
            } else if (power > i){
                return false;
            }
            power *= 2;
        }
    }

    public boolean bit(int i) {
        // 0 is a special case

        // Power of 2 is always 1 and trailing zeroes
        //     i = 1000000
        // i - 1 = 0111111
        // i & (i - 1) = 0

        // Not a power of two has non-zero i & (i - 1)
        //     i =       1001000
        // i - 1 =       1000111
        // i & (i - 1) = 1000000

        return i != 0 && (i & (i - 1)) == 0;
    }
}

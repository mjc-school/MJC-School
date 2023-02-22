package bitwise;

import org.junit.jupiter.api.Test;
import school.mjc.bitwise.PowerOfTwo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PowerOfTwoTest {

    private final PowerOfTwo powerOfTwo = new PowerOfTwo();

    @Test
    public void shouldReturnTrue_whenPassed1() {
        boolean result = powerOfTwo.isPowerOfTwo(1);

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrue_whenPassed8() {
        boolean result = powerOfTwo.isPowerOfTwo(8);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_whenPassed63() {
        boolean result = powerOfTwo.isPowerOfTwo(63);

        assertFalse(result);
    }
}

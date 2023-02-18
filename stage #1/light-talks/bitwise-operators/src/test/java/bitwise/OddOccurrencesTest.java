package bitwise;

import org.junit.jupiter.api.Test;
import school.mjc.bitwise.OddOccurrences;

import static org.junit.jupiter.api.Assertions.*;

class OddOccurrencesTest {

    OddOccurrences oddOccurrences = new OddOccurrences();

    @Test
    public void shouldReturnNumber_whenItsOnly() {
        int[] arr = { 5 };
        int expected = 5;

        int actual = oddOccurrences.getNumberWithOddOccurrences(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNumberWithOddOccurrences() {
        int[] arr = { 5, 4, 5, 3, 1, 4, 1 };
        int expected = 3;

        int actual = oddOccurrences.getNumberWithOddOccurrences(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNumberWithOddOccurrences2() {
        int[] arr = { 5, 4, 5, 3, 1, 4, 1, 3, 3, 3, 3 };
        int expected = 3;

        int actual = oddOccurrences.getNumberWithOddOccurrences(arr);

        assertEquals(expected, actual);
    }
}

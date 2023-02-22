package bitwise;

import org.junit.jupiter.api.Test;
import school.mjc.bitwise.Strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringsTest {

    private final Strings strings = new Strings();

    @Test
    public void shouldReturnTrue_whenStringIsAlphabet() {
        String s = "abcdefghijklmnopqrstuvwxyz";

        assertTrue(strings.hasAllCharacters(s));
    }

    @Test
    public void shouldReturnTrue_whenLacksOneLetter() {
        String s = "abcdefghijklmnopqrstuvwxy";

        assertFalse(strings.hasAllCharacters(s));
    }

    @Test
    public void shouldReturnTrue_whenStringIsAlphabetWithPrefix() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcdefghijklmnopqrstuvwxyz";

        assertTrue(strings.hasAllCharacters(s));
    }
}

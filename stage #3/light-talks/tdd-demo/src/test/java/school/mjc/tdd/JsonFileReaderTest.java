package school.mjc.tdd;

import org.junit.jupiter.api.Test;

import java.io.UncheckedIOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static school.mjc.tdd.AddressRecordMother.getDanilaRecord;
import static school.mjc.tdd.AddressRecordMother.getLinasRecord;

class JsonFileReaderTest {

    private final JsonFileReader reader = new JsonFileReader();

    @Test
    void shouldReadCorrectData() {
        List<AddressRecord> expected = List.of(getDanilaRecord(),
            getLinasRecord());

        List<AddressRecord> records = reader.read(
            "src/test/resources/address-book.json");

        assertEquals(expected, records);
    }

    @Test
    void shouldThrowExceptionWhenDataIsIncorrect() {
        assertThrows(UncheckedIOException.class,
            () -> reader.read(
                "src/test/resources/address-book-corrupted.json"));
    }
}

package school.mjc.tdd;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static school.mjc.tdd.AddressRecordMother.getDanilaRecord;
import static school.mjc.tdd.AddressRecordMother.getLinasRecord;

class AddressServiceTest {

    private final AddressService service = new AddressService();

    @Test
    void getById_shouldReturnNull_whenNothingRegistered() {
        Optional<AddressRecord> actual = service.getById(1);

        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldReturnPreviouslyRegisteredAddress() {
        AddressRecord record = getDanilaRecord();

        service.add(record);
        Optional<AddressRecord> actual = service.getById(record.getId());

        assertTrue(actual.isPresent());
        assertEquals(record, actual.get());
    }

    @Test
    void shouldReturnTwoPreviouslyRegisteredAddresses() {
        AddressRecord danila = getDanilaRecord();
        AddressRecord linas = getLinasRecord();

        service.add(danila);
        service.add(linas);
        Optional<AddressRecord> actual = service.getById(danila.getId());
        Optional<AddressRecord> actual2 = service.getById(linas.getId());

        assertTrue(actual.isPresent());
        assertTrue(actual2.isPresent());
        assertEquals(danila, actual.get());
        assertEquals(linas, actual2.get());
    }

    @Test
    void size_shouldReturn0_whenNothingRegistered() {
        int size = service.size();

        assertEquals(0, size);
    }

    @Test
    void size_shouldReturn1_whenOneAddressIsRegistered() {
        service.add(getDanilaRecord());

        int size = service.size();

        assertEquals(1, size);
    }

    @Test
    void shouldImportData() {
        AddressRecord danila = getDanilaRecord();
        AddressRecord linas = getLinasRecord();

        JsonFileReader reader = Mockito.mock(JsonFileReader.class);
        when(reader.read(anyString()))
            .thenReturn(List.of(danila, linas));

        service.importData("<filePath>", reader);

        Optional<AddressRecord> actual = service.getById(danila.getId());
        Optional<AddressRecord> actual2 = service.getById(linas.getId());

        assertTrue(actual.isPresent());
        assertTrue(actual2.isPresent());
        assertEquals(danila, actual.get());
        assertEquals(linas, actual2.get());
    }

    @Test
    void shouldThrowException_whenAddingRecordWithNullId() {
        AddressRecord record = getDanilaRecord()
            .setId(null);

        assertThrows(IllegalArgumentException.class,
            () -> service.add(record));
    }
}

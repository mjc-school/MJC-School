package school.mjc.tdd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class JsonFileReader implements FileReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<AddressRecord> read(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath),
                new TypeReference<List<AddressRecord>>(){});
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

package school.mjc.tdd;

import java.util.List;

public interface FileReader {

    List<AddressRecord> read(String filePath);
}

package school.mjc.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddressService {

    private Map<Integer, AddressRecord> addressRecordMap = new HashMap<>();

    public Optional<AddressRecord> getById(int id) {
        return Optional.ofNullable(addressRecordMap.get(id));
    }

    public void add(AddressRecord record) {
        if (record.getId() == null) {
            throw new IllegalArgumentException("Id can not be null");
        }
        addressRecordMap.put(record.getId(), record);
    }

    public int size() {
        return addressRecordMap.size();
    }

    public void importData(String filePath, FileReader reader) {
        List<AddressRecord> addressRecords = reader.read(filePath);

        for (AddressRecord addressRecord : addressRecords) {
            addressRecordMap.put(addressRecord.getId(), addressRecord);
        }
    }
}

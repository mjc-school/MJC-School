package school.mjc.tdd;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddressRecord {

    private Integer id;
    private String name;
    private String address;
}

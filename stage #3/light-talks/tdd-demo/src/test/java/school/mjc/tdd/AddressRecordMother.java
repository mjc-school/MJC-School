package school.mjc.tdd;

public class AddressRecordMother {

    public static AddressRecord getLinasRecord() {
        return new AddressRecord()
            .setId(2)
            .setName("Linas")
            .setAddress("Vilnius, Lithuania");
    }

    public static AddressRecord getDanilaRecord() {
        return new AddressRecord()
            .setId(1)
            .setName("Danila")
            .setAddress("Vilnius, Lithuania");
    }
}

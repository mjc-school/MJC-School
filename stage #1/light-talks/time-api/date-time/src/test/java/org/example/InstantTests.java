package org.example;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstantTests {


    @Test
    void testInstant() {
        Instant instant1 = Instant.now();
        long timeStampMillis = instant1.toEpochMilli();
        long timeStampSeconds = instant1.getEpochSecond();


        Instant instant2 = Clock.system(ZoneId.of("Europe/Paris")).instant();
        Instant instant3 = Clock.systemUTC().instant();
        Instant instant4 = Clock.systemDefaultZone().instant();
    }

    @Test
    void testInstantAndZonedDateTime() {
        ZoneId zoneIdMinsk = ZoneId.of("Europe/Minsk");
        ZonedDateTime zonedDateTimeAtMinsk = ZonedDateTime.of(2022, 9, 29, 18, 0, 0, 0, zoneIdMinsk);
        assertEquals("2022-09-29T18:00+03:00[Europe/Minsk]", zonedDateTimeAtMinsk.toString());

        Instant instantFromZDTAtMinsk = Instant.from(zonedDateTimeAtMinsk);
        assertEquals("2022-09-29T15:00:00Z", instantFromZDTAtMinsk.toString());


        ZoneId zoneIdBerlin = ZoneId.of("Europe/Berlin");
        ZonedDateTime zonedDateTimeAtBerlin = instantFromZDTAtMinsk.atZone(zoneIdBerlin);
        assertEquals("2022-09-29T17:00+02:00[Europe/Berlin]", zonedDateTimeAtBerlin.toString());
    }

}

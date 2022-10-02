package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OffsetDateTimeTests {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    @Test
    void testOffsetDateTimeNow() {
        ZoneOffset utcOffset = ZoneOffset.of(ZoneOffset.UTC.getId());
        OffsetDateTime offsetDateTimeByUTC = OffsetDateTime.now(utcOffset);
        
        ZoneOffset offsetPlusTwo = ZoneOffset.of("+02:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.now(offsetPlusTwo);

        int utcHour = offsetDateTimeByUTC.getHour();
        int plusTwoHour = offsetDateTime.getHour();

        assertEquals(utcHour + 2, plusTwoHour);
    }

    @Test
    void testZonedDateTimeNow2() {
        ZoneId zoneLondon = ZoneId.of("Europe/London");
        ZonedDateTime dateTimeLondon = ZonedDateTime.now(zoneLondon);

        ZoneId zoneBerlin = ZoneId.of("Europe/Berlin");
        ZonedDateTime dateTimeBerlin = dateTimeLondon.withZoneSameInstant(zoneBerlin);

        assertNotEquals(dateTimeLondon.getHour(), dateTimeBerlin.getHour());
    }

    @Test
    void testConvertOffsetDateTimeToAnotherZone() {
        ZoneOffset offsetByUTC = ZoneOffset.of(ZoneOffset.UTC.getId());
        LocalDateTime dateTime = LocalDateTime.of(2022, 9, 29, 18, 0);
        OffsetDateTime offsetDateTimeByUTC = OffsetDateTime.of(dateTime, offsetByUTC);

        ZoneOffset destination = ZoneOffset.of("+02:00");
        OffsetDateTime destinationOffsetDateTime = offsetDateTimeByUTC.atZoneSameInstant(destination).toOffsetDateTime();

        assertEquals("2022/09/29 18:00", offsetDateTimeByUTC.format(DATE_TIME_FORMATTER));
        assertEquals("2022/09/29 20:00", destinationOffsetDateTime.format(DATE_TIME_FORMATTER));
    }

    @Test
    void testParseOffsetDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2022-09-26T12:20:32.954366+02:00");
        assertEquals("2022-09-26T12:20:32.954366+02:00", offsetDateTime.toString());
    }

    @Test
    void testParseZonedDateTime() {
        ZonedDateTime offsetDateTime = ZonedDateTime.parse("2022-09-28T14:14:08.229219+02:00[Europe/Berlin]");
        assertEquals("2022-09-28T14:14:08.229219+02:00[Europe/Berlin]", offsetDateTime.toString());
    }

}

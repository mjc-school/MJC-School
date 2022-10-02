package org.example;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocalDateTimeTests {

    @Test
    void testLocalDate() {
        LocalDate date1 = LocalDate.of(2022, Month.SEPTEMBER, 29);
        LocalDate date2 = LocalDate.of(2000, Month.JANUARY, 1);

        Period period = Period.between(date2, date1);
        int daysBetween = period.getDays();
        assertEquals(28, daysBetween);

        long daysBetween2 = ChronoUnit.DAYS.between(date2, date1);
        assertEquals(28, daysBetween);
    }

    @Test
    void testLocalDateOfInstant() {
        LocalDate prevDate = LocalDate.of(2022, Month.SEPTEMBER, 1);
        LocalDate now = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        boolean isAfter = now.isAfter(prevDate);
        assertTrue(isAfter);
    }

    @Test
    void testLocalDateTime() {
        LocalDateTime date = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 0);
//       LocalDateTime dateTimePlusThree = dateTime.plus(3L, ChronoUnit.MONTHS);
        LocalDateTime dateTimePlusThree = date.plusMonths(3L);
        assertEquals("2022-09-29T18:00", date.toString());
        assertEquals("SEPTEMBER", date.getMonth().toString());
        assertEquals("DECEMBER", dateTimePlusThree.getMonth().toString());
    }

    @Test
    void testLocalDateTimeFromDateAndTime() {
        LocalDate localDate = LocalDate.of(2022, Month.SEPTEMBER, 29);
        LocalTime localTime = LocalTime.of(18, 30, 15);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        assertEquals("2022-09-29T18:30:15", localDateTime.toString());
    }

    @Test
    void testLocalDateTime2() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 0);
        assertEquals("2022-09-29T18:00", localDateTime.toString());

        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("GMT+02:30"));
        assertEquals("2022-09-29T18:00+02:30[GMT+02:30]", zonedDateTime.toString());

        Instant instant = zonedDateTime.toInstant();
        assertEquals("2022-09-29T15:30:00Z", instant.toString());


        LocalDateTime localDateTimeUTC = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        assertEquals("2022-09-29T15:30", localDateTimeUTC.toString());

        LocalDateTime localDateTimeAtMinsk = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Minsk"));
        assertEquals("2022-09-29T18:30", localDateTimeAtMinsk.toString());
    }

}

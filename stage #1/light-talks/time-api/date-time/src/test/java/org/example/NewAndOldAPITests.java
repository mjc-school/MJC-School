package org.example;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NewAndOldAPITests {

    @Test
    void testSpecificTime() {
        //Old
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        Date date = gregorianCalendar.getTime();
        assertEquals("Thu Sep 29 18:00:00 EEST 2022", date.toString());

        // New
        LocalDate localDate = LocalDate.of(2022, Month.SEPTEMBER, 29);
        assertEquals("2022-09-29", localDate.toString());

        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 30, 15, 10);
        assertEquals("2022-09-29T18:30:15.000000010", localDateTime.toString());

        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.of("+02:00"));
        assertEquals("2022-09-29T18:30:15.000000010+02:00", offsetDateTime.toString());

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Minsk"));
        assertEquals("2022-09-29T18:30:15.000000010+03:00[Europe/Minsk]", zonedDateTime.toString());
    }


    @Test
    void testChangingDateTime() {
        // Old
        GregorianCalendar calendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        Date date = calendar.getTime();
        assertEquals("Thu Sep 29 18:00:00 EEST 2022", date.toString());

        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DAY_OF_MONTH, 10);

        Date newDate = calendar.getTime();
        assertEquals("Fri Mar 10 18:00:00 EET 2000", newDate.toString());

        // New
        LocalDate localDate = LocalDate.of(2022, Month.SEPTEMBER, 29);
        assertEquals("2022-09-29", localDate.toString());

        LocalDate localDateNew = localDate.withYear(2000).withMonth(Month.MARCH.getValue()).withDayOfMonth(10);
        assertEquals("2000-03-10", localDateNew.toString());
        assertEquals("2000-March-10", localDateNew.format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd")));


        LocalDate localDateNew2 = localDate
                .plus(1, ChronoUnit.YEARS)
                .minusDays(5);
        assertEquals("2023-09-24", localDateNew2.toString());
    }

    @Test
    void testExtractingSpecificFields() {
        // Old
        GregorianCalendar calendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        int month = calendar.get(Calendar.MONTH);
        assertEquals(8, month);

        // New
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 0);
        Month monthNew = localDateTime.getMonth();
        assertEquals("SEPTEMBER", monthNew.toString());
    }


    @Test
    void testAddingAndSubtractingTime() {
        // Old
        GregorianCalendar calendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        assertEquals("Thu Sep 29 18:00:00 EEST 2022", calendar.getTime().toString());
        calendar.add(Calendar.HOUR_OF_DAY, -5);
        Date fiveHoursBefore = calendar.getTime();
        assertEquals("Thu Sep 29 13:00:00 EEST 2022", fiveHoursBefore.toString());

        // New
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 0);
        assertEquals("2022-09-29T18:00", localDateTime.toString());

        LocalDateTime localDateTimeFiveHoursBefore = localDateTime.minusHours(5);
        assertEquals("2022-09-29T13:00", localDateTimeFiveHoursBefore.toString());

        assertNotEquals(localDateTime, localDateTimeFiveHoursBefore);
    }

    @Test
    void testAlteringSpecificFields() {
        // Old
        GregorianCalendar calendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        assertEquals("Thu Sep 29 18:00:00 EEST 2022", calendar.getTime().toString());

        calendar.set(Calendar.MONTH, Calendar.JUNE);
        Date inJune = calendar.getTime();
        assertEquals("Wed Jun 29 18:00:00 EEST 2022", inJune.toString());

        // New
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 0);
        assertEquals("2022-09-29T18:00", localDateTime.toString());

        LocalDateTime inJuneNew = localDateTime.withMonth(Month.JUNE.getValue());
        assertEquals("2022-06-29T18:00", inJuneNew.toString());
    }


    @Test
    void testTruncating() {
        // Old
        GregorianCalendar calendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 15, 30);
        assertEquals("Thu Sep 29 18:15:30 EEST 2022", calendar.getTime().toString());
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date truncated = calendar.getTime();
        assertEquals("Thu Sep 29 18:00:00 EEST 2022", truncated.toString());

        // New
        LocalTime localTime = LocalTime.of(18, 15, 30);
        assertEquals("18:15:30", localTime.toString());
        LocalTime localTimeTruncated = localTime.truncatedTo(ChronoUnit.HOURS);
        assertEquals("18:00", localTimeTruncated.toString());
        assertEquals("18:00:00", localTimeTruncated.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    @Test
    void testGettingTimeSpanBetweenTwoPointsInTime() {
        // Old
        GregorianCalendar calendar1 = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        Date date = calendar1.getTime();

        GregorianCalendar calendar2 = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0);
        calendar2.add(Calendar.HOUR, 1);
        Date datePlusHour = calendar2.getTime();

        long span = datePlusHour.getTime() - date.getTime();
        assertEquals(3_600_000L, span);

        // New
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 18, 0);
        LocalDateTime hourLaterNew = localDateTime.plusHours(1);
        Duration duration = Duration.between(localDateTime, hourLaterNew);
        assertEquals("PT1H", duration.toString());
        assertEquals(1L, duration.toHours());
        assertEquals(60L, duration.toMinutes());
    }

    @Test
    void testTimeFormattingAndParsing() throws ParseException {
        // Old
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0).getTime();
        String formattedDate = dateFormat.format(date);
        assertEquals("2022-09-29", formattedDate);
        Date parsedDate = dateFormat.parse(formattedDate);
        assertEquals("Thu Sep 29 00:00:00 EEST 2022", parsedDate.toString());

        // New
        LocalDate dateNew = LocalDate.of(2022, Month.SEPTEMBER, 29);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateNew = dateNew.format(formatter);
        assertEquals("2022-09-29", formattedDateNew);
        LocalDate parsedLocalDate = LocalDate.parse(formattedDateNew, formatter);
        assertEquals("2022-09-29", parsedLocalDate.toString());
    }

    @Test
    void testNumberOfDaysInMonth() {
        // Old
        Calendar calendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        assertEquals(30, daysInMonth);

        // New
        int daysInMonthNew = LocalDate.of(2022, Month.SEPTEMBER, 29).lengthOfMonth();
        assertEquals(30, daysInMonthNew);

    }

    @Test
    void testInteractingWithOldAPI() {
        Instant instantFromCalendar = GregorianCalendar.getInstance().toInstant();
        ZonedDateTime zonedDateTimeFromCalendar = new GregorianCalendar(2022, Calendar.SEPTEMBER, 29, 18, 0).toZonedDateTime();
        Date dateFromInstant = Date.from(Instant.now());
        GregorianCalendar calendarFromZonedDateTime = GregorianCalendar.from(ZonedDateTime.now());
        Instant instantFromDate = new Date().toInstant();
        ZoneId zoneIdFromTimeZone = TimeZone.getTimeZone("PST").toZoneId();
    }

}

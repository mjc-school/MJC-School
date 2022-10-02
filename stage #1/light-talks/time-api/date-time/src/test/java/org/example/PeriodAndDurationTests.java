package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeriodAndDurationTests {

    @Test
    void testDurationBetween() {
        LocalDate prevDate = LocalDate.of(2022, Month.SEPTEMBER, 28);
        LocalDate date = LocalDate.of(2022, Month.SEPTEMBER, 29);

//        LocalDateTime midnight = LocalDateTime.of(date, LocalTime.MIDNIGHT);
        LocalDateTime midnight = date.atStartOfDay();
        LocalDateTime midnightPrev = prevDate.atStartOfDay();

        Duration durationBetween = Duration.between(midnightPrev, midnight);
        assertEquals(1L, durationBetween.toDays());
        assertEquals(24L, durationBetween.toHours());
        assertEquals(1440L, durationBetween.toMinutes());
    }

    @Test
    void testDurationBetween2() {
        LocalDateTime left = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 12, 30, 10);
        LocalDateTime right = LocalDateTime.of(2022, Month.SEPTEMBER, 29, 16, 0, 0);

        Duration durationBetween = Duration.between(left, right);
        assertEquals(0L, durationBetween.toDays());
        assertEquals(3, durationBetween.toHours());
        assertEquals(209, durationBetween.toMinutes());
        assertEquals(12590, durationBetween.toSeconds());
    }

    @Test
    void testPeriod() {
        Period periodOfYear = Period.ofYears(1);
        assertEquals(1, periodOfYear.getYears());
        assertEquals(0, periodOfYear.getMonths());
        assertEquals(0, periodOfYear.getDays());

        Period period = Period.of(1, 3, 5);
        assertEquals(1, period.getYears());
        assertEquals(3, period.getMonths());
        assertEquals(5, period.getDays());
    }

    @Test
    void testPeriodPlusDate() {
        LocalDate date = LocalDate.of(2022, Month.SEPTEMBER, 29);
        assertEquals("2022-09-29", date.toString());

//        Period period = Period.of(0, 0, 1);
        Period period = Period.ofDays(1);
        LocalDate nextDay = date.plus(period);
        assertEquals("2022-09-30", nextDay.toString());
    }

    @Test
    void testPeriodBetween() {
        LocalDate prevDate = LocalDate.of(2022, Month.MAY, 28);
        LocalDate date = LocalDate.of(2022, Month.SEPTEMBER, 29);

        Period period = Period.between(prevDate, date);
        assertEquals(0, period.getYears());
        assertEquals(4, period.getMonths());
        assertEquals(1, period.getDays());
    }

}

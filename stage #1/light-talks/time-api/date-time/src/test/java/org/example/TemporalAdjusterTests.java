package org.example;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemporalAdjusterTests {

    @Test
    void testGetNextFriday() {
        LocalDate date = LocalDate.of(2022, Month.SEPTEMBER, 29);
        assertEquals("2022-09-29", date.toString());

        LocalDate nextFriday = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        assertEquals("2022-09-30", nextFriday.toString());
        assertEquals("2022-09-01", date.with(TemporalAdjusters.firstDayOfMonth()).toString());
        assertEquals("2022-09-02", date.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)).toString());
        assertEquals("2022-10-03", date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).toString());
    }

    @Test
    void testCustomTemporalAdjuster() {
        LocalDate date = LocalDate.of(2022, Month.SEPTEMBER, 1);
        assertEquals("2022-09-01", date.toString());

        LocalDate datePlus10Days = date.plusDays(10L);
        assertEquals("2022-09-11", datePlus10Days.toString());

        TemporalAdjuster temporalAdjuster = temporal -> temporal.plus(10, ChronoUnit.DAYS);
        LocalDate dateAdjust10Days = date.with(temporalAdjuster);
        assertEquals("2022-09-11", dateAdjust10Days.toString());
    }

}

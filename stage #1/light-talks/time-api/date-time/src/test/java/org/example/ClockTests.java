package org.example;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClockTests {

    @Test
    void testSystemDefaultZone() {
        Clock clock = Clock.systemDefaultZone();

        ZoneId zone = clock.getZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
    }

    @Test
    void testSystemUTC() {
        Clock clock = Clock.systemUTC();
        Instant instant = clock.instant();
    }

    @Test
    void testDateNowFromClock() {
        Clock clock = Clock.systemUTC();
        LocalDate date = LocalDate.now(clock);
        LocalDateTime time = LocalDateTime.now(clock);
        OffsetDateTime offsetTime = OffsetDateTime.now(clock);
    }

    @Test
    void testSystemAtZone() {
        Clock clock = Clock.system(ZoneId.of("Europe/Minsk"));
        Instant instant = clock.instant();
    }

    @Test
    void testWithOffset() {
        Clock baseClock = Clock.systemDefaultZone();
        Instant baseInstant = baseClock.instant();

        Clock clock = Clock.offset(baseClock, Duration.ofHours(72));
        Instant instantWith72HoursDuration = clock.instant();
        assertTrue(instantWith72HoursDuration.isAfter(baseInstant));

        clock = Clock.offset(baseClock, Duration.ZERO);
        Instant instantWithZeroOffset = clock.instant();

        clock = Clock.offset(baseClock, Duration.ofHours(-72));
        Instant instantWithMinus72HoursDuration = clock.instant();
        assertTrue(instantWithMinus72HoursDuration.isBefore(baseInstant));
    }

    @Test
    void testWithTick() {
        Clock clockDefaultZone = Clock.systemDefaultZone();
        Clock clockTick = Clock.tick(clockDefaultZone, Duration.ofSeconds(30));

        Instant instant = clockDefaultZone.instant();
        Instant instantWithTick = clockTick.instant();
    }

    @Test
    void testWithTickSeconds() {
        ZoneId zoneId = ZoneId.of("Europe/Minsk");
        Clock clock = Clock.tickSeconds(zoneId);
        Instant instant = clock.instant();

    }

    @Test
    void testTickMinutes() {
        ZoneId zoneId = ZoneId.of("Europe/Minsk");
        Clock clock = Clock.tickMinutes(zoneId);
    }

    @Test
    void testFixed() throws InterruptedException {
        Clock systemDefaultZoneClock = Clock.systemDefaultZone();
        Clock fixedClock = Clock.fixed(Instant.parse("2022-09-29T18:00:00.00Z"),
                ZoneId.of("Europe/Minsk"));

        Instant systemBefore = systemDefaultZoneClock.instant();
        Instant fixedBefore = fixedClock.instant();

        TimeUnit.SECONDS.sleep(1);

        Instant systemAfter = systemDefaultZoneClock.instant();
        Instant fixedAfter = fixedClock.instant();

        assertEquals(fixedBefore, fixedAfter);
        assertNotEquals(systemBefore, systemAfter);
    }

}



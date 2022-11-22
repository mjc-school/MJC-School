package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeFormatterTests {


    @Test
    void testDateTimeFormatter() {
        LocalDateTime date = LocalDateTime.of(2022, 9, 29, 18, 10, 15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String result = date.format(formatter);
        assertEquals("29.09.2022 18:10:15", result);
        Integer integer = Optional.of("123")
                .map(str -> 1)
                .orElse(2);
    }

    @Test
    void testDateTimeFormatter2() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 9, 29, 18, 10, 15);

        assertEquals("29.09.2022 18:10:15", dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        assertEquals("29/09/2022", dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assertEquals("2022/09/29", dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        assertEquals("2022-09-29", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Test
    void testParseByPattern() {
        String formatDate = "29-09-2022T09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime result = LocalDateTime.parse(formatDate, formatter);

        assertEquals("2022-09-29", result.toLocalDate().toString());
        assertEquals("09:24", result.toLocalTime().toString());
    }

    @Test
    void testParseByStrangePattern() {
        String formatDate = "2022-09-29STRANGE09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'STRANGE'HH:mm");
        LocalDateTime result = LocalDateTime.parse(formatDate, formatter);

        assertEquals("2022-09-29", result.toLocalDate().toString());
        assertEquals("09:24", result.toLocalTime().toString());
    }

    @Test
    void testParseByStrangePattern2() {
        String formatDate = "2022-09-29👀09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'👀'HH:mm");
        LocalDateTime result = LocalDateTime.parse(formatDate, formatter);

        assertEquals("2022-09-29", result.toLocalDate().toString());
        assertEquals("09:24", result.toLocalTime().toString());

        String formattedDateTime = result.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'\uD83D\uDC40'HH:mm"));
        assertEquals("2022-09-29\uD83D\uDC4009:24", formattedDateTime);
        assertEquals("2022-09-29👀09:24", formattedDateTime);
    }

}

package ru.popkov.restaurantmanager.web.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatters {

    public static class LocalDateFormatter implements Formatter<LocalDate> {

        @Override
        public LocalDate parse(String text, Locale locale) {
            return LocalDate.parse(text);
        }

        @Override
        public String print(LocalDate lt, Locale locale) {
            return lt.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }
}

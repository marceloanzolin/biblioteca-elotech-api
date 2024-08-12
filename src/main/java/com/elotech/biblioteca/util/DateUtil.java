package com.elotech.biblioteca.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String localDateToString(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    public static LocalDate stringToLocalDate(String date, DateTimeFormatter formatter) {
        return LocalDate.parse(date, formatter);
    }
}

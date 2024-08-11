package com.elotech.biblioteca.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String localDateFormater(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }
}

package com.elotech.biblioteca.util;

public final class StringUtil {

    public static String somenteNumeros(String string) {
        return string.replaceAll("[^0-9]", "");
    }
}

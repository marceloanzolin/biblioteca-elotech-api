package com.elotech.biblioteca.util;

import com.elotech.biblioteca.exception.RegraNegocioException;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public final class StringUtil {

    private static final String FORMATO_ISBN_10 = "###-##-####-#";
    private static final String FORMATO_ISBN_13 = "###-##-#####-##-#";

    public static String somenteNumeros(String string) {
        return string.replaceAll("[^0-9]", "");
    }

    public static String formatIsbn(String isbn) {

        String isbnNumeros = somenteNumeros(isbn);

        if (isbnNumeros == null || isbnNumeros.length() != 10 && isbnNumeros.length() != 13) {
            new RegraNegocioException("ISBN deve conter 10 ou 13 números");
        }
        if (isbnNumeros.length() == 10) {
            return formataString(isbnNumeros, FORMATO_ISBN_10);
        } else {
            return formataString(isbnNumeros, FORMATO_ISBN_13);
        }
    }

        public static String formataString(String value, String mask) {
            try {
                MaskFormatter mf = new MaskFormatter(mask);
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(value);
            } catch (ParseException e) {
                return "";
            }
        }
    }



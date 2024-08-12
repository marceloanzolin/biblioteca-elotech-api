package com.elotech.biblioteca.util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public final class StringUtil {

    private static final String FORMATO_ISBN_10 = "###-##-####-#";
    private static final String FORMATO_ISBN_13 = "###-##-#####-##-#";
    private static final String FORMATO_TELEFONE_CELULAR = "(##)-#####-####";
    private static final String FORMATO_TELEFONE_FIXO = "(##) ####-####";

    public static String somenteNumeros(String string) {
        return string.replaceAll("[^0-9]", "");
    }

    public static String formataIsbn(String isbn) {
        String isbnNumeros = somenteNumeros(isbn);

        if (isbnNumeros.length() == 10) {
            return formataString(isbnNumeros, FORMATO_ISBN_10);
        } else {
            return formataString(isbnNumeros, FORMATO_ISBN_13);
        }
    }

    public static String formataTelefone(String telefone) {
        String telefoneNumeros = somenteNumeros(telefone);

        if (telefoneNumeros.length() == 11) {
            return formataString(telefone, FORMATO_TELEFONE_CELULAR);
        } else if (telefoneNumeros.length() == 10){
            return formataString(telefone, FORMATO_TELEFONE_FIXO);
        }else{
            return telefoneNumeros;
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



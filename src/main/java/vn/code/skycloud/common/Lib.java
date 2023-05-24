package vn.code.skycloud.common;

import java.text.Normalizer;
import java.util.Collection;

public class Lib {

    public static boolean isEmpty(String value) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String wildcard(String value, boolean unacent) {
        if (isEmpty(value)) {
            return "%";
        }

        if (unacent) {
            value = removeAccents(value);
        }

        return "%" + value.toLowerCase() + "%";
    }

    public static String wildcard(String value) {
        return wildcard(value, false);
    }

    private static String normalize(String input) {
        return input == null ? null : Normalizer.normalize(input, Normalizer.Form.NFKD);
    }

    static String removeAccents(String input) {
        return normalize(input).replaceAll("\\p{M}", "");
    }

    public static boolean isNullOrEmpty(final Collection<?> c) {
        return c == null || c.isEmpty();
    }

}

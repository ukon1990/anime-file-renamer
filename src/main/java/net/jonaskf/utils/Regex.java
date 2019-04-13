package net.jonaskf.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean contains(String contains, String pattern) {
        return Regex.getMatches(contains, pattern)
                .matches();
    }

    public static Matcher getMatches(String contains, String pattern) {
        return Pattern.compile(pattern)
                .matcher(contains);
    }
}

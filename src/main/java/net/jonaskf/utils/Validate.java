package net.jonaskf.utils;

public class Validate {
    public static boolean isValidEmail(String mail) {
        return Regex.contains(
                mail,
                "[a-zA-Z]{1,}@[a-zA-Z]{1,}[.][a-zA-Z]{1,}");
    }
}

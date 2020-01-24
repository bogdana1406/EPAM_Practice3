package ua.nure.panchenko.practice3;

import java.util.regex.Pattern;

public class Part6 {

    private static String input = Util.readFile("part6.txt");

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("(\\b\\w+\\b)(?=[\\s\\S]*\\b\\1\\b[\\s\\S]*\\b\\1\\b)",
                Pattern.UNICODE_CHARACTER_CLASS);
        String res = pattern.matcher(input+" "+input).replaceAll("_$1");
        res = res.substring(0, res.length() - 1 - pattern.matcher(input).replaceAll("_$1").length());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert(input));
    }
}

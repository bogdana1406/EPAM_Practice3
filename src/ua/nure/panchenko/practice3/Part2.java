package ua.nure.panchenko.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    private static String input = Util.readFile("part2.txt");

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        String min = getMin(input);
        String max = getMax(input);
        sb.append(min + "\n");
        sb.append(max);
        return sb.toString();
    }

    private static String getMin(String input) {
        StringBuilder sb = new StringBuilder();
        int count = Integer.MAX_VALUE;
        sb.append("Min: ");
        Pattern pattern = Pattern.compile("[\\p{Alpha}\\p{InCyrillic}]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            Pattern pattern2 = Pattern.compile(matcher.group());
            Matcher matcher2 = pattern2.matcher(sb.toString().substring(5));
            if (count > matcher.group().length()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Min: ");
                count = matcher.group().length();
                sb2.append(matcher.group());
                sb = sb2;
            } else if (count == matcher.group().length() && !(matcher2.find())) {
                sb.append(", " + matcher.group());

            }
        }
        return sb.toString();
    }

    private static String getMax(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append("Max: ");
        Pattern pattern = Pattern.compile("[\\p{Alpha}\\p{InCyrillic}]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            Pattern pattern2 = Pattern.compile(matcher.group());
            Matcher matcher2 = pattern2.matcher(sb.toString().substring(5));
            if (count < matcher.group().length()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Max: ");
                count = matcher.group().length();
                sb2.append(matcher.group());
                sb = sb2;
            } else if (count == matcher.group().length() && !(matcher2.find())) {
                sb.append(", " + matcher.group());

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(input));
    }
}

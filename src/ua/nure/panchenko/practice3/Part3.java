package ua.nure.panchenko.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static String input = Util.readFile("part3.txt");

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();

        String[] lines = input.split(System.lineSeparator());

        for (int i = 0; i < lines.length; i++) {
            String[] word = lines[i].split("\\s");
            String pattern = "[\\p{Alpha}\\p{InCyrillic}]{3,}[\\p{Punct}$]*";

            for (int j = 0; j < word.length; j++) {
                if (word[j].matches(pattern)) {
                    String first = word[j].substring(0, 1);
                    if (first.toUpperCase().equals(first)) {
                        word[j] = word[j].replaceFirst(first, first.toLowerCase());
                    } else {
                        word[j] = word[j].replaceFirst(first, first.toUpperCase());
                    }
                } else {
                    Pattern pattern2 = Pattern.compile("[\\p{Alpha}\\p{InCyrillic}]+[\\p{Punct}\\p{Pd}$]*");
                    Matcher matcher = pattern2.matcher(word[j]);

                    while (matcher.find()) {
                        String partWord = matcher.group();
                        String patternLength = "[\\p{Alpha}\\p{InCyrillic}]{3,}[\\p{Punct}\\p{Pd}$]*";
                        boolean isLength = Pattern.matches(patternLength, partWord);
                        if (isLength) {

                            String first = partWord.substring(0, 1);
                            if (first.toUpperCase().equals(first)) {
                                partWord = partWord.replaceFirst(first, first.toLowerCase());
                            } else {
                                partWord = partWord.replaceFirst(first, first.toUpperCase());
                            }
                        }
                        sb.append(partWord);
                        word[j] = word[j].substring(matcher.group().length());
                    }
                }
                sb.append(word[j] + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(System.lineSeparator());
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(input));
    }
}

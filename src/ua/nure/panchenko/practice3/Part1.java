package ua.nure.panchenko.practice3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static String input = Util.readFile("part1.txt");

    public static String convert1(String input) {
        String[] lines = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String[] word = lines[i].split(";");
            sb.append(word[0] + ": " + word[2] + System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        String[] lines = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String[] word = lines[i].split("[\\s\\;]");
            sb.append(word[2] + " " + word[1] + " (email: " + word[3] + ")" + System.lineSeparator());

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String convert3(String input) {
        Pattern patern = Pattern.compile("^?(.+;)(.+;)(.+)(@.+)");
        Matcher matcher = patern.matcher(input);
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        while (matcher.find()) {
            Pattern pattern2 = Pattern.compile(matcher.group(4).substring(1));
            Matcher matcher2 = pattern2.matcher(sb);
            if (!matcher2.find()) {
                sb.append(System.lineSeparator() + matcher.group(4).substring(1)
                        + " ==> "
                        + matcher.group(1).substring(0, matcher.group(1).length() - 1));
            } else {
                Pattern p3 = Pattern.compile(matcher.group(4).substring(1) + ".+");
                Matcher m3 = p3.matcher(sb);
                m3.find();
                sb.insert(m3.end(),
                        ", " + matcher.group(1).substring(0, matcher.group(1).length() - 1));
            }
        }
        return sb.toString().substring(2);
    }

    public static String convert4(String input) {
        Random rnd = new Random();
        String[] lines = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        sb.append(lines[0] + ";Password" + System.lineSeparator());
        for (int i = 1; i < lines.length; i++) {
            int random = rnd.nextInt(9999);
            while (random < 1001) {
                random = rnd.nextInt(9999);
            }
            sb.append(lines[i] + ";" + random + System.lineSeparator());

        }
        return sb.toString();
    }



    public static void main(String[] args) {
        System.out.print(Part1.convert1(input)+System.lineSeparator());
        System.out.println(Part1.convert2(input)+System.lineSeparator());
        System.out.println(Part1.convert3(input)+System.lineSeparator());
        System.out.print(Part1.convert4(input)+System.lineSeparator());
    }
}

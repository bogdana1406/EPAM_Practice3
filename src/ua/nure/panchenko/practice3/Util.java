package ua.nure.panchenko.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }
}

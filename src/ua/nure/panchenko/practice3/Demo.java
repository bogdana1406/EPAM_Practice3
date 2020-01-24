package ua.nure.panchenko.practice3;

import java.security.NoSuchAlgorithmException;

public class Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Part1.main(args);
        Part2.main(args);
        Part3.main(args);
        Part4.main(new String[] {"password", "MD5"});
        Part5.main(args);
        Part6.main(args);
    }
}

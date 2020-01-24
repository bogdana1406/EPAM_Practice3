package ua.nure.panchenko.practice3;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    private static final int PARAMETR = 16;
    private static String byteToHex(byte b) {
        char[]hexDigits = new char[2];
        hexDigits[0]= Character.forDigit((b >> 4) & 0xF, PARAMETR);
        hexDigits[1]= Character.forDigit((b & 0xF), PARAMETR);
        return new String(hexDigits);
    }

    public static String  hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();

        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        for (int i = 0; i < hash.length; i++) {
            sb.append(byteToHex(hash[i]));
        }
        char[] charsArr = sb.toString().toCharArray();
        for (int i = 0; i < charsArr.length; i++) {
            charsArr[i] = Character.toUpperCase(charsArr[i]);
        }

        return new String(charsArr);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }
}

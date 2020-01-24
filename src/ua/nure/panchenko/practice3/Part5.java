package ua.nure.panchenko.practice3;

public class Part5 {

    private static final String[] roman = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] decimal = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100};

    private static final char[] romanArr = {'I', 'V', 'X', 'L', 'C'};
    private static final int[] decimalArr = {1, 5, 10, 50, 100};

    public static String decimal2Roman(int x) {

        int times;
        StringBuilder sb = new StringBuilder();
        for (int i = decimal.length - 1; i >= 0; i--) {
            times = x / decimal[i];
            x %= decimal[i];
            while (times > 0) {
                sb.append(roman[i]);
                times--;
            }
        }
        return sb.toString();
    }

    public static int roman2Decimal(String s) {
        int result = 0;
        int lastNumber = 0;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            char romanChar = s.charAt(i);
            int intValue = decimalArr[getPosition(romanChar)];
            if (lastNumber > intValue) {
                result -= intValue;
            } else {
                result += intValue;
            }
            lastNumber = intValue;
        }

        return result;
    }

    private static int getPosition(char ch) {
        int index = -1;
        for (int i = 0; i < romanArr.length; i++) {
            if (ch == romanArr[i]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        final int maxNum = 100;
        for (int i = 1; i <= maxNum; i++) {
            System.out.println(i + " --> " + decimal2Roman(i) + " --> "
                    + roman2Decimal(decimal2Roman(i)));
        }

    }
}

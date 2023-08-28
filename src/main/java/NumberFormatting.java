package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberFormatting {
    public static String formatNumberString(String numberString) {
        BigDecimal number = new BigDecimal(numberString);
        String formattedString;

        if (numberString.contains(".")) {
            numberString += "0";//有小数点则给小数点末尾补个零 防止charAt的时候越界
            int decimalSeparatorIndex = numberString.indexOf(".");
            if (numberString.charAt(decimalSeparatorIndex + 1) == '0') {
                formattedString = number.toBigInteger().toString();
            } else {
                formattedString = number.setScale(1, RoundingMode.DOWN).toPlainString();
            }
        } else {
            formattedString = number.toBigInteger().toString();
        }

        return formattedString;
    }

    public static void main(String[] args) {
        String numberString1 = "123.35";
        String numberString2 = "123.05";
        String numberString3 = "456.0";
        String numberString4 = "789";
        String numberString5 = "789.";
        String numberString6 = "0.";

        System.out.println(formatNumberString(numberString1));  // Output: 123.3
        System.out.println(formatNumberString(numberString2));  // Output: 123
        System.out.println(formatNumberString(numberString3));  // Output: 456
        System.out.println(formatNumberString(numberString4));  // Output: 789
        System.out.println(formatNumberString(numberString5));  // Output: 789
        System.out.println(formatNumberString(numberString6));  // Output: 0
    }
}

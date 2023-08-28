package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HelloWorld {
    public static void main(String[] args) {
        BigDecimal val = new BigDecimal("3.1415926").setScale(1, RoundingMode.DOWN);
        System.out.println(val);

        BigDecimal val2 = new BigDecimal("3.000").setScale(1, RoundingMode.DOWN);
        System.out.println(val2);
    }
}

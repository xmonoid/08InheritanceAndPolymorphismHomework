package com.tsystems.autotestuni.basic;

public class InhAndPolyBasic {

    /**
     * Implement a method which reverses a number.
     *
     * 12345 -> 54321
     * 10000 -> 1 (because 00001 is just 1)
     *
     */
    public static int reverse(int number) {
        int result = 0;
        while (number != 0) {
            result *= 10;
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    /**
     * Implement a method which reverses a char array.
     *
     * {'a', 'b', 'c'} -> {c', 'b', 'a'}
     *
     */
    public static char[] reverse(char[] chars) {
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[chars.length - i - 1];
        }
        return result;
    }
}

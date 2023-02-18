package school.mjc.bitwise;

// Show a strings task
// Go through Basics class
// Go through PowerOfTwo class
// Go through Strings example (without bitset)
// Go through Flags
// Go through BitSet example
// Go through Strings BitSet example
// Go through OddOccurrences example

import com.google.common.base.Strings;

import java.util.stream.IntStream;

public class Basics {

    public static void main(String[] args) {
        shiftRightNegative();
    }

    private static void and() {
        // x | y | x & y
        // 0 | 0 | 0
        // 1 | 0 | 0
        // 0 | 1 | 0
        // 1 | 1 | 1

        //     13 = 1101
        //      6 = 0110
        // 13 & 6 = 0100 = 4

        print(13, 6,13 & 6);
        print(56, 29,56 & 29);
    }

    private static void or() {
        // x | y | x or y
        // 0 | 0 | 0
        // 1 | 0 | 1
        // 0 | 1 | 1
        // 1 | 1 | 1

        //     9 = 1001
        //     5 = 0101
        // 9 & 5 = 1101 = 13

        print(9, 5,9 | 5);
        print(10, 2,10 | 2);
    }

    private static void xor() {
        // x | y | x ^ y
        // 0 | 0 | 0
        // 1 | 0 | 1
        // 0 | 1 | 1
        // 1 | 1 | 0

        //     9 = 1001
        //     5 = 0101
        // 9 ^ 5 = 1100 = 12

        print(9, 5, 9 ^ 5);
        print(10, 2, 10 ^ 2);
    }

    private static void not() {
        // x | ~x
        // 0 | 1
        // 1 | 0

        //  9 = 0000 0000 0000 0000 0000 0000 0000 1001
        // ~9 = 1111 1111 1111 1111 1111 1111 1111 0110 = -10
        // Ones' complement - https://en.wikipedia.org/wiki/Ones%27_complement

        printResult(~9);
    }

    private static void shiftLeft() {
        //      3 = 0011
        // 3 << 1 = 0110 = 6
        // 3 << 2 = 1100 = 12

        printResult(3 << 1);
        printResult(3 << 2);
    }

    private static void shiftRight() {
        //      5 = 101
        // 5 >> 1 = 010 = 2
        // 5 >> 2 = 001 = 1
        // 5 >> 3 = 000 = 0

        printResult(5 >> 1);
        printResult(5 >> 2);
        printResult(5 >> 3);
    }

    private static void shiftRightNegative() {
        // -10       = 1111 1111 1111 1111 1111 1111 1111 0110
        // -10 >> 1  = 1111 1111 1111 1111 1111 1111 1111 1011
        // -10 >>> 1 = 0111 1111 1111 1111 1111 1111 1111 1011

        printFullResult(-10 >> 1);
        printFullResult(-10 >>> 1);
    }

    private static void print(int first, int second, int result) {
        String firstBin = Integer.toBinaryString(first);
        String secondBin = Integer.toBinaryString(second);
        String resultBin = Integer.toBinaryString(result);
        int maxLength = IntStream.of(firstBin.length(), secondBin.length(), resultBin.length())
                        .max().getAsInt();
        System.out.println("First:  " + Strings.padStart(firstBin, maxLength, '0'));
        System.out.println("Second: " + Strings.padStart(secondBin, maxLength, '0'));
        System.out.println("Result: " + Strings.padStart(resultBin, maxLength, '0'));
        System.out.println("Result decimal: " + result);
        System.out.println();
    }

    private static void printResult(int result) {
        System.out.println("Result = " + result);
        System.out.println("Result binary = " + Integer.toBinaryString(result));
    }

    private static void printFullResult(int result) {
        System.out.println("Result = " + result);
        System.out.println("Result binary = " + Strings.padStart(
                Integer.toBinaryString(result), 32, '0'));
    }
}

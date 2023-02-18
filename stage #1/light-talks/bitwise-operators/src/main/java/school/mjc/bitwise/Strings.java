package school.mjc.bitwise;

import java.util.BitSet;

/**
 * Task - write a method that accepts a string,
 * and checks if the string contains all latin characters.
 * The strings will be lowercase only.
 */
public class Strings {

    public boolean hasAllCharacters(String string) {
        return naiveCycle(string);
    }

    public static boolean naiveCycle(String string) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (string.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean array(String string) {
        int[] count = new int[26];
        for (char c : string.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i : count) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean arrayBoolean(String string) {
        boolean[] flags = new boolean[26];
        for (char c : string.toCharArray()) {
            flags[c - 'a'] = true;
        }
        for (boolean b : flags) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static boolean bytes(String string) {
        int result = 0;
        // result = 00000000 00000000 00000000 00000000

        for (char c : string.toCharArray()) {
            result |= 1 << (c - 'a');

            if (result == (1 << 26) - 1) {
                return true;
            }
        }
        return false;
    }
    
    //        (string)                           Mode  Cnt  Score   Error  Units
    //naive   abcdefghijklmnopqrstuvwxyz         avgt       0.092          us/op
    //naive   abcdefghijklmnopqrstuvwxy          avgt       0.093          us/op
    //naive   <longerString>                     avgt       0.162          us/op
    //
    //array   abcdefghijklmnopqrstuvwxyz         avgt       0.037          us/op
    //array   abcdefghijklmnopqrstuvwxy          avgt       0.044          us/op
    //array   <longerString>                     avgt       0.123          us/op
    //
    //arrayBoolean  abcdefghijklmnopqrstuvwxyz   avgt       0.048          us/op
    //arrayBoolean  abcdefghijklmnopqrstuvwxy    avgt       0.037          us/op
    //arrayBoolean  <lingString                  avgt       0.071          us/op
    //
    //bytes   abcdefghijklmnopqrstuvwxyz         avgt       0.027          us/op
    //bytes   abcdefghijklmnopqrstuvwxy          avgt       0.030          us/op
    //bytes   <longerString>                     avgt       0.069          us/op

    public static boolean bitSet(String string) {
        BitSet bitSet = new BitSet();
        for (char c : string.toCharArray()) {
            bitSet.set(c - 'a');
            if (bitSet.cardinality() == 26) {
                return true;
            }
        }
        return false;
    }
}

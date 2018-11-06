package practice.problemSolving.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you cannot use additional data structures?
 *
 * @author Yashraj R. Sontakke
 */
public class StringUniqueChars_1_1 {
    public void isUnique(final String input) {
        if (input == null || input.isEmpty()) {
            System.out.println(String.format("%s IS UNIQUE", input));
            return;
        }
        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c : input.toCharArray()) {
            if (characters.contains(c)) {
                System.out.println(String.format("%s IS NOT UNIQUE", input));
                return;
            } else {
                characters.add(c);
            }

        }
        System.out.println(String.format("%s IS UNIQUE", input));

    }

    public void isUnique1(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println(String.format("%s IS UNIQUE", input));
            return;
        }
        char[] chars = input.toLowerCase().toCharArray();
        Arrays.sort(chars);
        char previous = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == previous) {
                System.out.println(String.format("%s IS NOT UNIQUE", input));
                return;
            } else {
                previous = chars[i];
            }
        }
        System.out.println(String.format("%s IS UNIQUE", input));
    }

    public void isUnique2(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println(String.format("%s IS UNIQUE", input));
            return;
        }
        char[] chars = input.toLowerCase().toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                System.out.println(String.format("%s IS NOT UNIQUE", input));
                return;
            }
        }
        System.out.println(String.format("%s IS UNIQUE", input));
    }

    public static void main(String[] args) {
        StringUniqueChars_1_1 s = new StringUniqueChars_1_1();
        s.isUnique("MY NAME IS YASHRAJ");
        s.isUnique("ABCD");
        s.isUnique(null);
        s.isUnique("");
        s.isUnique("  ");

        s.isUnique1("MY NAME IS YASHRAJ");
        s.isUnique1("ABCD");
        s.isUnique1(null);
        s.isUnique1("");
        s.isUnique1("  ");

        s.isUnique2("MY NAME IS YASHRAJ");
        s.isUnique2("ABCD");
        s.isUnique2(null);
        s.isUnique2("");
        s.isUnique2("  ");

    }
}

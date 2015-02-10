package practice.problems;

import java.util.Arrays;

/**
 * Checks if two strings are anagrams.
 *
 * @author Yashraj R. Sontakke
 */
public class Anagram {

    public void isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] charArray1 = a.toCharArray();
        char[] charArray2 = b.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if (Arrays.equals(charArray1, charArray2)) {
            System.out.println(String.format("Strings %s,%s are anagrams", a, b));
        } else {
            System.out.println(String.format("Strings %s, %s are not anagrams", a, b));
        }

    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();

        anagram.isAnagram("YASH", "hAsY");
        anagram.isAnagram("YASHRAJ", "WARhAsY");
    }
}

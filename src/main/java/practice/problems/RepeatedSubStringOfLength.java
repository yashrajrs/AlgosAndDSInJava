package practice.problems;

import java.util.TreeSet;

/**
 * Find all the repeating sub-string sequence of specified length in a large string sequence. The sequences returned i.e. the output must be sorted alphabetically.
 * <p/>
 * For e.g.
 * <p/>
 * Input String: "ABCACBABC"
 * repeated sub-string length: 3
 * <p/>
 * Output: ABC
 * <p/>
 * Input String: "ABCABCA"
 * repeated sub-string length: 2
 * <p/>
 * Output: AB, BC, CA
 * <p/>
 *
 * @author Yashraj R. Sontakke
 */
public class RepeatedSubStringOfLength {

    public TreeSet<String> repeatedSubStrings(String input, int length) {
        TreeSet<String> output = new TreeSet<String>();
        for (int i = 0; i < input.length() - 1 - length; i++) {
            String currentSubString = input.substring(i, i + length);
            String remainingString = input.substring(i + length);
            if (remainingString.contains(currentSubString)) {
                output.add(currentSubString);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        RepeatedSubStringOfLength repeatedSubStringOfLength = new RepeatedSubStringOfLength();
        System.out.println(repeatedSubStringOfLength.repeatedSubStrings("ABCACBABC", 3).toString());
        System.out.println(repeatedSubStringOfLength.repeatedSubStrings("ABCABCA", 2).toString());
    }
}

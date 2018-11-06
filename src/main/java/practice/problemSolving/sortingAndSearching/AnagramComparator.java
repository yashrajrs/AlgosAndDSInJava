package practice.problemSolving.sortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator for comparing two string.
 *
 * @author Yashraj R. Sontakke
 */
public class AnagramComparator implements Comparator<String> {

    public String sortChars(String s) {
        char[] c = s.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }


    public int compare(String s, String s2) {
        return sortChars(s).compareTo(sortChars(s2));
    }
}

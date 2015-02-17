package practice.problemSolving;

import java.util.Arrays;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each
 * other.
 *
 * @author Yashraj R. Sontakke
 */
public class SortStringArrays_11_2 {

    public void sortArrays(String[] input) {
        Arrays.sort(input, new AnagramComparator());
    }

    public static void main(String[] args) {
        SortStringArrays_11_2 s = new SortStringArrays_11_2();
        String[] input = {"bcds", "race", "care", "abcd", "xys"};
        s.sortArrays(input);
        System.out.println(Arrays.toString(input));
    }
}

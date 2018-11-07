package practice.otherProblems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

 Example 1:

 Input: "aabb"
 Output: ["abba", "baab"]
 Example 2:

 Input: "abc"
 Output: []
 */
public class PalindromePermutations2 {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int[] table = new int[128];
        int count = 0;

        for(char c: s.toCharArray()) {
            table[c]++;
            count = (table[c] % 2 == 0) ? count-1: count+1;
        }
        if (s.equals("") || count > 1) {
            return result;
        }
        String temp = "";
        for (int i=0;i<128 && count == 1; i++) {
            if (table[i] %2 == 1) {
                temp+= (char)i;
                break;
            }
        }
        backtrackHelper(table,temp,result,s.length());
        return result;
    }

    public void backtrackHelper(int[] table, String curr,List<String> res,int length) {
        if (curr.length() == length) {
            res.add(new String(curr));
            return;
        }
        for (int i=0;i<128;i++) {
            if (table[i] > 1) {
                table[i] -=2;
                char c = (char)i;
                String temp = c + curr + c;
                backtrackHelper(table, temp, res, length);
                table[i] +=2;
            }
        }
    }

    public static void main(String[] args) {
        PalindromePermutations2 palindromePermutations = new PalindromePermutations2();
        System.out.println(palindromePermutations.generatePalindromes("racecar"));
        System.out.println(palindromePermutations.generatePalindromes("ab"));
        System.out.println(palindromePermutations.generatePalindromes("abba"));
    }
}

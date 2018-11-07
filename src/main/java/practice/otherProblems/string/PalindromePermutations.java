package practice.otherProblems.string;

import java.util.HashMap;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 Example 1:

 Input: "code"
 Output: false
 Example 2:

 Input: "aab"
 Output: true
 Example 3:

 Input: "carerac"
 Output: true
 */
public class PalindromePermutations {

    /**
     * Time complexity : O(n).

     Space complexity : O(n).
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for(char key: hashMap.keySet()) {
            count+= hashMap.get(key) %2;
        }
        return count <=1;
    }

    public static void main(String[] args) {
        PalindromePermutations palindromePermutations = new PalindromePermutations();
        System.out.println(palindromePermutations.canPermutePalindrome("racecar"));
        System.out.println(palindromePermutations.canPermutePalindrome("aap"));
        System.out.println(palindromePermutations.canPermutePalindrome("aasp"));
        System.out.println(palindromePermutations.canPermutePalindrome("code"));
    }
}

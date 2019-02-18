package practice.otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s== null || s.length() == 0 || p.length() > s.length()) {
            return result;
        }
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        for (int i=0;i<(s.length()-p.length()+1);i++) {
            String window = s.substring(i, i+p.length());
            char[] cw = window.toCharArray();
            Arrays.sort(cw);
            if (Arrays.equals(pArray, cw)) {
                result.add(i);
            }
        }
        return result;
    }
}

package practice.problems.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

 Example 1:

 Input: "eceba"
 Output: 3
 Explanation: t is "ece" which its length is 3.
 Example 2:

 Input: "ccaabbb"
 Output: 5
 Explanation: t is "aabbb" which its length is 5.
 */
public class LongestSubstringwithAtmostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c)+1);
                continue;
            }
            if(hashMap.size() < 2) {
                hashMap.put(c, 1);
                continue;
            }
            result = Math.max(result, i-left);
            while(hashMap.size() == 2 && left < s.length()) {
                char sc = s.charAt(left);
                hashMap.put(sc, hashMap.get(sc) - 1);
                if(hashMap.get(sc) == 0) {
                    hashMap.remove(sc);
                    left++;
                    break;
                }
                left++;
            }
            hashMap.put(c, 1);
        }
        result = Math.max(result, s.length()-left);
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringwithAtmostTwoDistinctCharacters l = new LongestSubstringwithAtmostTwoDistinctCharacters();
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("eceba")); // 3
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("ccaabbb")); // 5
    }
}

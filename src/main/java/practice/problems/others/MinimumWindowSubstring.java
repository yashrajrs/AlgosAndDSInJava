package practice.problems.others;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 Note:

 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        String result = "";

        HashMap<Character, Integer> target = new HashMap<>();
        for (Character c: t.toCharArray()) {
            if (target.containsKey(c)) {
                target.put(c, target.getOrDefault(c,0) + 1);
            } else {
                target.put(c, 1);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = s.length()+1;

        int count = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if (target.containsKey(c)) {
                if (map.containsKey(c)) {
                    if (map.get(c) < target.get(c)) {
                        count++;
                    }
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                    count++;
                }
            }

            if (count == t.length()) {
                char sc = s.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc)) {
                        map.put(sc, map.get(sc)-1);
                    }
                    left++;
                    sc = s.charAt(left);
                }

                if (i-left+1 < minLen) {
                    minLen = i-left+1;
                    result = s.substring(left, i+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumSubString = new MinimumWindowSubstring();
        System.out.println(minimumSubString.minWindow("ADOBECODEBANC", "ABC"));

    }
}

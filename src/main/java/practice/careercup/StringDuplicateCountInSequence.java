package practice.careercup;

import java.util.*;

/**
 * Print the count of duplicate char in a given string in same order. Ex: Input- 'abbaccdbac', Output- 'a3b3c3d1'
 */
public class StringDuplicateCountInSequence {

    public String getCount(String input) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        Set<Character> hashSet = new HashSet<Character>();

        for (Character c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        StringBuffer sb = new StringBuffer();
//        for (Character c: input.toCharArray()) {
//            if (!hashSet.contains(c)) {
//                sb.append(c);
//                sb.append(map.get(c));
//                hashSet.add(c);
//            }
//        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringDuplicateCountInSequence s = new StringDuplicateCountInSequence();
        String input = "abbaccdbac";
        System.out.println(s.getCount(input));
    }
}

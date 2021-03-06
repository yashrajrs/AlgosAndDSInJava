package practice.otherProblems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * <p/>
 * Note: All inputs will be in lower-case.
 *
 * @author Yashraj R. Sontakke
 */
public class Anagrams {

    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String s = String.valueOf(array);
            if (map.get(s) == null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(s, list);
            } else {
                map.get(s).add(strs[i]);
            }
        }

        for (ArrayList<String> values : map.values()) {
            if (values.size() > 1) {
                for (String i : values) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Anagrams anagramsStringList = new Anagrams();
        String[] input = {"trees", "bike", "cars", "steer", "arcs"};
        System.out.println(anagramsStringList.anagrams(input).toString());

    }
}

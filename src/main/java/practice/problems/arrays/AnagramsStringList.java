package practice.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Given a list of strings, return a list of lists of strings that groups all anagrams.
 * <p/>
 * Ex. given {trees, bike, cars, steer, arcs}
 * return { {cars, arcs}, {bike}, {trees, steer} }
 *
 * @author Yashraj R. Sontakke
 */
public class AnagramsStringList {

    public void anagrams(final ArrayList<String> input) {
        TreeMap<String, ArrayList<String>> anagramMap = new TreeMap<String, ArrayList<String>>();

        for (String string : input) {
            char[] c = string.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (anagramMap.containsKey(key)) {
                ArrayList<String> strings = anagramMap.get(key);
                strings.add(string);
//                anagramMap.put(key, strings);
            } else {
                ArrayList<String> strings = new ArrayList<String>(Arrays.asList(string));
                anagramMap.put(key, strings);
            }
        }

        System.out.println(anagramMap.values().toString());
    }

    public static void main(String[] args) {
        final AnagramsStringList anagramsStringList = new AnagramsStringList();
        anagramsStringList.anagrams(new ArrayList<String>(Arrays.asList("trees", "bike", "cars", "steer", "arcs")));

    }

}

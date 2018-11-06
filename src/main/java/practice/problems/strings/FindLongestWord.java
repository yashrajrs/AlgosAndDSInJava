package practice.problems.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * EXAMPLE
 * Input: cat, banana, dog, nana, walk, walker, dogwalker
 * Output: dogwalker
 *
 * @author Yashraj R. Sontakke
 */
public class FindLongestWord {
    public void getLongestWord(String[] words) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String word : words) {
            map.put(word, true);
        }
        Arrays.sort(words, new LengthComparator());
        for (String word : words) {
            if (canBuildWord(map, true, word)) {
                System.out.println(word);
                return;
            }
        }
        System.out.println("No such word");
    }

    public boolean canBuildWord(HashMap<String, Boolean> map, boolean isOriginalWord, String word) {
        if (map.containsKey(word) && !isOriginalWord) {
            return map.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (map.containsKey(left) && map.get(left) == true && canBuildWord(map, false, right)) {
                return true;
            }
        }
        map.put(word, false);
        return false;

    }


    public class LengthComparator implements Comparator<String> {

//        @Override
        public int compare(String s, String s2) {
            if (s.length() > s2.length()) {
                return -1;
            } else if (s.length() == s2.length()) {
                return 0;
            }
            return 1;
        }
    }


    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        String[] input = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
        findLongestWord.getLongestWord(input);
    }
}

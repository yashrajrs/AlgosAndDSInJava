package practice.problems;


import com.google.common.collect.ImmutableSet;

import java.util.*;

/**
 * Given two words of equal length that are in a dictionary, write a method to
 * transform one word into another word by changing only one letter at a time.
 * The new word you get in each step must be in the dictionary.
 * EXAMPLE
 * Input: DAMP, LIKE
 * Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
 *
 * @author Yashraj R. Sontakke
 */
public class DictionaryConvertWords {

    public LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
        startWord = startWord.toUpperCase();
        stopWord = stopWord.toUpperCase();

        Queue<String> actionQueue = new LinkedList<String>();
        Set<String> visitedSet = new HashSet<String>();
        Map<String, String> backTrackMap = new TreeMap<String, String>();

        actionQueue.add(startWord);
        visitedSet.add(startWord);

        while (!actionQueue.isEmpty()) {
            String w = actionQueue.poll();
            for (String v : getOneEditWords(w, dictionary)) {
                if (v.equals(stopWord)) {
                    LinkedList<String> list = new LinkedList<String>();
                    list.add(v);

                    while (w != null) {
                        list.add(0, w);
                        w = backTrackMap.get(w);
                    }
                    return list;
                }

                if (!visitedSet.contains(v)) {
                    actionQueue.add(v);
                    visitedSet.add(v);
                    backTrackMap.put(v, w);
                }
            }
        }
        return null;
    }

    private Set<String> getOneEditWords(String word, Set<String> dictionary) {
        Set<String> words = new TreeSet<String>();
        for (int i = 0; i < word.length(); i++) {
            char[] wordArray = word.toCharArray();
            for (char c = 'A'; c <= 'Z'; c++) {
                if (c != word.charAt(i)) {
                    wordArray[i] = c;
                    String string = new String(wordArray);
                    if (dictionary.contains(string)) {
                        words.add(string);
                    }
                }
            }
        }
        return words;
    }

    public static void main(String[] args) {
        DictionaryConvertWords convertWords = new DictionaryConvertWords();
        Set<String> dictionary = ImmutableSet.of("DAMP", "LAMP", "LIMP", "LIME", "LIKE", "ACES", "ICIC", "DSAZ");
        System.out.println(convertWords.transform("damp", "like", dictionary));
    }
}

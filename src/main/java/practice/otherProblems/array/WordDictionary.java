package practice.otherProblems.array;

import com.google.common.collect.LinkedHashMultimap;

import java.util.*;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 Example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {
    Map<Integer, ArrayList<String>> map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        ArrayList<String> words = new ArrayList<>();
        if(map.containsKey(word.length())) {
            words = map.get(word.length());
        }
        words.add(word);
        map.put(word.length(), words);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        List<String> list = map.get(word.length());
        if(list == null) {
            return false;
        }
        for(String base:list) {
            if(base.equals(word)) {
                return true;
            }
            int i=0;
            while(i<word.length()) {
                if(word.charAt(i) == base.charAt(i) || word.charAt(i) =='.') {
                    i++;
                } else {
                    break;
                }
            }
            if (i == word.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad")); // -> false
        System.out.println(w.search("bad")); // -> true
        System.out.println(w.search(".ad")); // -> true
        System.out.println(w.search("b..")); // -> true
    }
}

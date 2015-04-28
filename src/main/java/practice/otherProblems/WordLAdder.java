package practice.otherProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p/>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * <p/>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p/>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * @author Yashraj R. Sontakke
 */
public class WordLAdder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict.size() == 0) {
            return 0;
        }
        wordDict.add(endWord);
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        Set<String> visited = new HashSet<String>();

        wordQueue.add(beginWord);
        distanceQueue.add(1);
        visited.add(beginWord);

        int result = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            String currentWord = wordQueue.pop();
            Integer currentDistance = distanceQueue.pop();

            if (currentWord.equals(endWord)) {
                result = Math.min(result, currentDistance);
            }

            for (int i = 0; i < currentWord.length(); i++) {
                char[] charArray = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if (wordDict.contains(newWord) && !visited.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currentDistance + 1);
                        visited.add(newWord);
                    }
                }
            }
        }
        if (result < Integer.MAX_VALUE) {
            return result;
        }
        return 0;
    }

    public static void main(String[] args){
        WordLAdder w = new WordLAdder();
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        System.out.println(w.ladderLength("hit", "cog", wordDict));
    }
}

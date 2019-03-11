package practice.otherProblems.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



 Example:

 Input:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 Output: "ball"
 Explanation:
 "hit" occurs 3 times, but it is a banned word.
 "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 Note that words in the paragraph are not case sensitive,
 that punctuation is ignored (even if adjacent to words, such as "ball,"),
 and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        for(String ban:banned) {
            banSet.add(ban);
        }
        String[] split = paragraph.toLowerCase().replace(",", "").replace(".", "").split(" ");

        for(String word: split) {
            if(!banSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        String res = null;
        for(String word: map.keySet()) {
            if(res == null || map.get(res) < map.get(word)) {
                res = word;
            }
        }
        return res;
    }

    public static void main(String[] args){
        MostCommonWord m = new MostCommonWord();
        String[] words = {"hit"};
        System.out.println(m.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", words)); // ball
    }
}

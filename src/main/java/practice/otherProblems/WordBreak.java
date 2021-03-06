package practice.otherProblems;

import com.google.common.collect.Sets;
import practice.hackerrank.KthElementLinkedList;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine
 * if s can be segmented into a space-separated sequence of one or more dictionary words.

 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].

 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author Yashraj R. Sontakke
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length() == 0){
            return false;
        }
        if (wordDict.size() == 0){
            return s.length() == 0;
        }

        boolean[] checker = new boolean[s.length()+1];
        checker[0] = true;

        for (int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (checker[j] && wordDict.contains(s.substring(j,i))){
                    checker[i] = true;
                }

                if (checker[i]){
                    break;
                }
            }
        }
        return checker[s.length()];
    }

    /**
     * Exceeds time limit
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, Set<String> wordDict) {
        if(s==null || s.length() == 0){
            return false;
        }
        return helper(s, 0, wordDict);
    }

    public boolean helper(String s, int start, Set<String> wordDict){
        if (start==s.length()){
            return true;
        }
        for (int i=start+1;i<=s.length();i++){
            if(wordDict.contains(s.substring(start,i))){
                if (helper(s, i, wordDict)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);

        while(!queue.isEmpty()) {
            int start = queue.remove();
            if(visited[start] == 0) {
                for(int end = start+1;end<=s.length();end++) {
                    if(wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if(end == s.length()) {
                            return true;
                        }
                    }
                }

                visited[start] = 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        WordBreak w = new WordBreak();

        Set<String> input1 = Sets.newHashSet("leet", "code");
        System.out.println(w.wordBreak("leetcode" , input1));
        System.out.println(w.wordBreak2("leetcode" , input1));

        List<String> input2 = Arrays.asList("leet", "code");
        System.out.println(w.wordBreak("leetcode" , input2));
    }
}

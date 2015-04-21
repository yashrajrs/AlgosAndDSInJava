package practice.otherProblems;

import com.google.common.collect.Sets;

import java.util.Set;

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

    public static void main(String[] args){
        WordBreak w = new WordBreak();

        Set<String> input1 = Sets.newHashSet("leet", "code");
        System.out.println(w.wordBreak("leetcode" , input1));
    }
}

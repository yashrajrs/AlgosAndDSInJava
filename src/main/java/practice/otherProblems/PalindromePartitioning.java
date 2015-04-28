package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 * Return all possible palindrome partitioning of s.

 * For example, given s = "aab",
 * Return

 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return result;
        }
        ArrayList<String> partition = new ArrayList<String>();
        addPartition(s, 0, partition, result);
        return result;
    }

    public void addPartition(String s, int start, ArrayList<String> partition, List<List<String>> result){
        if(s.length() == start){
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }
        for(int i = start+1; i <= s.length(); i++){
            String subString = s.substring(start, i);
            if(isPalindrome(subString)){
                partition.add(subString);
                addPartition(s, i, partition, result);
                partition.remove(partition.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args){
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab").toString());
    }
}

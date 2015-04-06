package practice.otherProblems;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @author Yashraj R. Sontakke
 */
public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();

        for (int i=0;i<s.length();i++){
            if (hashMap.get(s.charAt(i)) == null){
                hashMap.put(s.charAt(i), i);
            }else{
                maxLength = Math.max(maxLength, hashMap.size());
                i = hashMap.get(s.charAt(i));
                hashMap.clear();
            }
        }
        return maxLength;
    }

    public int length(String s){
        char[] charArray = s.toCharArray();
        boolean[] array = new boolean[256];
        int maxLength =0;
        int start = 0;

        for (int i=0;i<charArray.length;i++){
            char current = charArray[i];
            if(array[current]){
                maxLength = Math.max(i-start,maxLength);
                for (int k = start;k<i;k++){
                    if (charArray[k] == current){
                        start = k+1;
                        break;
                    }
                    array[charArray[k]] = false;
                }
            }   else{
                array[current] = true;
            }
        }
        maxLength = Math.max(maxLength, charArray.length-start);
        return maxLength;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeats l = new LongestSubstringWithoutRepeats();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));

        System.out.println(l.length("abcabcbb"));
        System.out.println(l.length("bbbbb"));

        Character[][] array = new Character[2][2];
        for (int i=0;i<2;i++){
            for (int j=0;j<2;j++){

                System.out.println(array[i][j]);
            }
        }
    }
}

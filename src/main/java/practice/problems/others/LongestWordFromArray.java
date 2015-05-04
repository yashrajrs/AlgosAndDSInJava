package practice.problems.others;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * given 2 arrays wrds[] , chars[] as an input to a function such that
 * wrds[] = [ "abc" , "baa" , "caan" , "an" , "banc" ]
 * chars[] = [ "a" , "a" , "n" , "c" , "b"]
 * Function should return the longest word from words[] which can be constructed from the chars in chars[] array.
 * for above example - "caan" , "banc" should be returned

 * Note: Once a character in chars[] array is used, it cant be used again.
 * eg: words[] = [ "aat" ]
 * characters[] = [ "a" , "t" ]
 * then word "aat" can't be constructed, since we've only 1 "a" in chars[].
 *
 * @author Yashraj R. Sontakke
 */
public class LongestWordFromArray {

    public Set<String> getWords(Character[] chars, String[] wrds){
        Set<String> result = Sets.newHashSet();
        char[] array = new char[chars.length];
        for (int i=0;i<array.length;i++){
            array[i] =' ';
        }
        getWords(chars, wrds, array, 0, result);
        System.out.println(result);
        if (result.isEmpty()){
            return result;
        }
        HashMap<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
        for (String s : result){
            if (map.containsKey(s.length())){
                Set<String> list = map.get(s.length());
                list.add(s);
                map.put(s.length(), list);
            }else{
                Set<String> list = Sets.newHashSet();
                list.add(s);
                map.put(s.length(), list);
            }
        }
        int maxLength = Collections.max(map.keySet());
        return map.get(maxLength);
    }

    public void getWords(Character[] chars, String[] wrds, char[] array, int index, Set<String> result){
        String currentWord = new String(array).trim();
        for (String word : wrds){
            if (currentWord.equals(word)) {
                result.add(currentWord);
            }
            if (index >=array.length){
                return;
            }
            for (int i=0;i<chars.length;i++){
                Character c = chars[i];
                if (c != null && word.length() > index){
                    if (word.charAt(index) == c){
                        array[index] = c;
                        chars[i] = null;
                        getWords(chars, wrds, array, index+1, result);
                        chars[i] = c;
                        array[index] = ' ';
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        String[] words = {"abc" , "baa" , "caan" , "an" , "banc", "aby"};
        Character[] chars = {'a','a','n','c','b'};
        LongestWordFromArray l = new LongestWordFromArray();
        System.out.println(l.getWords(chars,words));


        String[] words1 = {"aat"};
        Character[] chars1 = {'a','t'};
        System.out.println(l.getWords(chars1,words1));

    }
}

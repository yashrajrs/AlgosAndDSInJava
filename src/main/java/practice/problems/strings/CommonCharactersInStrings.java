package practice.problems.strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Write a program that gives count of common characters presented in an array
 * of strings..(or array of character arrays)

 * For eg.. for the following input strings..

 * aghkafgklt
 * dfghako
 * qwemnaarkf

 * The output should be 3. because the characters a, f and k are present in all 3 strings.

 * Note: The input strings contains only lower case alphabets
 *
 * @author Yashraj R. Sontakke
 */
public class CommonCharactersInStrings {

    public void common(String[] strings){
        if (strings == null || strings.length <2){
            System.out.println("No common characters");
            return;
        }

        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for (String string : strings){
            HashSet<Character> set = new HashSet<Character>();
            for (Character c : string.toCharArray()){
                if (!set.contains(c)){
                    set.add(c);
                    if (hashMap.get(c) == null){
                        hashMap.put(c,1);
                    }else{
                        hashMap.put(c, hashMap.get(c)+1);
                    }
                }
            }
        }
        int count =0;
        for (Character c : hashMap.keySet()){
            if (hashMap.get(c) == strings.length){
                System.out.print(c + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("Common characters = " + count);
    }

    public static void main(String[] args){
        CommonCharactersInStrings c = new CommonCharactersInStrings();
        String[] input = {"aghkafgklt", "dfghako","qwemnaarkf"};
        c.common(input);
    }
}

package practice.problems;

import java.util.Arrays;

/**
 * Checks if input string is anagram using dictionary.
 *
 * @author Yashraj R. Sontakke
 */
public class AnagramDictionary {
    public String[] dict = {"abcd","xyz","lmn"};

    public boolean isAnagram(String input){
        input = input.toLowerCase();
        char[] inputCharArray = input.toCharArray();
        Arrays.sort(inputCharArray);

        for (final String dictionaryString: dict){
            if (Arrays.equals(inputCharArray, dictionaryString.toCharArray())){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        AnagramDictionary anagramDictionary = new AnagramDictionary();
        System.out.println(anagramDictionary.isAnagram("ZYx"));
        System.out.println(anagramDictionary.isAnagram("ZYax"));
    }
}

package practice.problems.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 * A mapping of digit to letters (just like on the telephone buttons) is given below.



 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author Yashraj R. Sontakke
 */
public class LetterCombinationsOfPhoneNumber {
    private String[] letters = {"","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {

        char[] charArray = new char[digits.length()];
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.trim().length() == 0){
            return result;
        }
        letterCombinations(digits, 0, charArray, result);
        return result;
    }

    public void letterCombinations(String digits, int i, char[] array, ArrayList<String> result){
        if(i==digits.length()){
            result.add(new String(array).trim());
            return;
        }
        if (digits.charAt(i) == '0' || digits.charAt(i) == '1'){
            array[i] = ' ';
            letterCombinations(digits, i+1, array, result);
            return;
        }
        String values = letters[digits.charAt(i)-'1'];
        for(int j=0;j<values.length();j++){
            array[i] = values.charAt(j);
            letterCombinations(digits, i+1, array, result);
        }
    }



    public void lc(String digits, int i, char[] array, ArrayList<String> result){
        if (i== array.length){
            result.add(new String(array).trim());
            return;
        }
        if (digits.charAt(i) == '0' || digits.charAt(i) == '1'){
            array[i] =' ';
            lc(digits, i+1, array, result);
        }
        String values = letters[digits.charAt(i)-'1'];
        for (char c : values.toCharArray()){
            array[i] = c;
            lc(digits, i+1, array, result);
        }

    }

    public List<String> letterCombinations2(String digits) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        ArrayList<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        ArrayList<Character> temp = new ArrayList<>();
        getString(digits, result, temp, map);
        return result;

    }

    public void getString(String digits, ArrayList<String> result, ArrayList<Character> temp, HashMap<Integer, String> map) {
        if (digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for(int i=0; i<temp.size(); i++){
                arr[i] = temp.get(i);
            }
            result.add(new String(arr));
            return;
        }
        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);
        for (int i=0;i<letters.length();i++) {
            temp.add(letters.charAt(i));
            getString(digits.substring(1), result, temp, map);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber l = new LetterCombinationsOfPhoneNumber();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations("123"));
        System.out.println(l.letterCombinations("1230"));
        System.out.println(l.letterCombinations(""));

        System.out.println(l.letterCombinations2("23"));
        System.out.println(l.letterCombinations2("123"));
        System.out.println(l.letterCombinations2("1230"));
        System.out.println(l.letterCombinations2(""));
    }
}

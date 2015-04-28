package practice.problems.others;

import java.util.ArrayList;
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

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber l = new LetterCombinationsOfPhoneNumber();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations("123"));
        System.out.println(l.letterCombinations("1230"));
        System.out.println(l.letterCombinations(""));
    }
}

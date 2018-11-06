package practice.careercup;

import java.util.ArrayList;
import java.util.List;

/**
 * Input argument of a method is a list of char array.
 * The method have to print all the possible combination of input char(s)...
 * For example if the input argument has ['A','B','C','D'] the output should be A,B,C,AB,AC,AD,BC,BD,CD,ABC,ACD,BCD,ABCD
 */
public class InputCombinations {

    public List<List<Character>> getCombinations(char[] input) {
        List<List<Character>> result = new ArrayList<List<Character>>();
        for (Character c : input) {
            List<List<Character>> temp = new ArrayList<List<Character>>();
            for (List<Character> list : result) {
                temp.add(new ArrayList<Character>(list));
            }
            for (List<Character> list: temp) {
                list.add(c);
            }
            List<Character> list = new ArrayList<Character>();
            list.add(c);
            temp.add(list);
            result.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        InputCombinations i = new InputCombinations();
        char[] input = {'A','B','C', 'D'};
        List<List<Character>> combinations = i.getCombinations(input);
        System.out.println(combinations.toString());
    }
}

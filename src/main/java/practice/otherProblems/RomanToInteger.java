package practice.otherProblems;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/4/15
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] array = s.toCharArray();
        int output = 0;
        int val;
        for (int i = 0; i < array.length; i++) {
            val = map.get(array[i]);
            if (i == array.length - 1 || map.get(array[i + 1]) <= val) {
                output += val;
            } else {
                output -= val;
            }
        }
        return output;
    }

    public static void main(String[] args){
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt("DCCCLXIII"));
    }
}

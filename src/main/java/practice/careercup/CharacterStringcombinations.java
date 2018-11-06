package practice.careercup;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**Given a number print the number of combinations you can derive from the number. 1=A, 2=B, 26=Z, 0=+.

 For example: 1123 can be represented by 1,1,2,3 which would stand for AABC.
 Another representation - 11,23 - JW
 Another representation - 1,1,23 - AAW
 Another representation - 11,2,3 - JBC

 For number 1123, there will be 5 combinations.

 Created by yashraj on 7/24/16.
 */
public class CharacterStringCombinations {

    Map<String, String> map = new HashMap<String, String>();

    public void populateMap() {
        map.put("0", "+");
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
        map.put("13", "M");
        map.put("14", "N");
        map.put("15", "O");
        map.put("16", "P");
        map.put("17", "Q");
        map.put("18", "R");
        map.put("19", "S");
        map.put("20", "T");
        map.put("21", "U");
        map.put("22", "V");
        map.put("23", "W");
        map.put("24", "X");
        map.put("25", "Y");
        map.put("26", "Z");
    }



    public void getCombinations(String input, int index, ArrayList<String> list, HashSet<ArrayList<String>> result) {
        if (index == input.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }


        String s = input.substring(index, index + 1);
        String charVal = map.get(s);
        list.add(charVal);
        getCombinations(input, index+1, list, result);
        list.remove(list.size()-1);

        if (index + 1 <input.length()) {
            String sub = input.substring(index, index + 2);
            String val = map.get(sub);
            if (val != null) {
                list.add(val);
                getCombinations(input, index+2, list, result);
                list.remove(list.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        CharacterStringCombinations c = new CharacterStringCombinations();
        c.populateMap();
        String input = "1123";
        ArrayList<String> list = new ArrayList<String>();
        HashSet<ArrayList<String>> result = new HashSet<ArrayList<String>>();
        c.getCombinations(input, 0, list, result);
        System.out.println(result.toString());
    }
}

package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 * For example:
 * Given "25525511135",

 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * @author Yashraj R. Sontakke
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12){
            return result;
        }
        dfs(s, "", result, 0);
        return result;
    }

    public void dfs(String s, String tmp, ArrayList<String> result, int count){
        if(count == 3 && isValid(s)){
            result.add(String.format("%s%s", tmp, s));
            return;
        }
        for(int i=1; i<4 && i<s.length();i++){
            String subString = s.substring(0,i);
            if(isValid(subString)){
                dfs(s.substring(i),String.format("%s%s.", tmp, subString), result, count+1);
            }
        }
    }

    public boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return s.equals("0");
        }
        Integer num = Integer.parseInt(s);
        return num > 0 && num <=255;
    }

    public static void main(String[] args){
        RestoreIpAddresses r = new RestoreIpAddresses();
        System.out.println(r.restoreIpAddresses("25525511135").toString());
    }
}

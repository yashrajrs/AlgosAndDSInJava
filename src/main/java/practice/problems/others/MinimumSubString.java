package practice.problems.others;

import java.util.HashMap;

/**
 * Given an input string and a target string, find the minimum
 * substring of the input string that contains all of the characters in the target string
 *
 * @author Yashraj R. Sontakke
 */
public class MinimumSubString {

    public void findMinSubString(String input, String target){
        String min = "";
        for (int i=0;i<input.length();i++){
            for (int j=i+1;j<input.length();j++){
                String subString = input.substring(i,j);
                if (isValidSubString(subString, target)){
                    if (min.isEmpty()){
                        min= subString;
                    }else if (min.length() > subString.length()){
                        min = subString;
                    }
                }
            }
        }
        System.out.println(min);
    }

    public boolean isValidSubString(String input, String output){
        for (int i =0;i<output.length();i++){
            if (input.indexOf(output.charAt(i)) < 0){
                return  false;
            }
        }
        return true;
    }


    public void minSubString(String input, String target){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : target.toCharArray()){
            if (map.get(c) == null){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        int count = 0;
        int start  = 0;
        String minString = null;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i=0;i<input.length();i++){
            if (count == target.length()){
                if (minString == null || minString.length() > i-start){
                    minString =  input.substring(start,i);
                }
                hashMap = new HashMap<Character, Integer>();
                count = 0;
            }
            if (input.charAt(i) == target.charAt(0)){
                hashMap = new HashMap<Character, Integer>();
                count = 0;
                start = i;
            }
            if (map.get(input.charAt(i)) !=null){
                if (map.get(input.charAt(i)) != hashMap.get(input.charAt(i))){
                    if (hashMap.get(input.charAt(i)) == null){
                        hashMap.put(input.charAt(i),1);
                    }else{
                        hashMap.put(input.charAt(i), hashMap.get(input.charAt(i)) + 1);
                    }
                    count++;
                }
            }
        }

        if (count == target.length()){
            if (minString == null || minString.length() > input.length()-start){
                minString =  input.substring(start,input.length());
            }
        }

        System.out.println(minString);
    }

    public static void main(String[] args){
        MinimumSubString minimumSubString = new MinimumSubString();

        minimumSubString.findMinSubString("ABCDEFS","BDF");
        minimumSubString.findMinSubString("ABCDEFSBDEF","BDF");
        minimumSubString.findMinSubString("ABCDEFSBEDFBDF","BDF");

        minimumSubString.minSubString("ABCDEFS","BDF");
        minimumSubString.minSubString("ABCDEFSBDEF","BDF");
        minimumSubString.minSubString("ABCDEFSBEDFBDF","BDF");
    }
}

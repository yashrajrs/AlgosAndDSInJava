package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of ints, return a string identifying the range of numbers
 * <p/>
 * Example
 * Input arr - [0 1 2 7 21 22 1098 1099]
 * Output - "0-2,7,21-22,1098-1099"
 *
 * @author Yashraj R. Sontakke
 */
public class ArrayRange {

    public List<String> getRange(int[] in){
        int start = in[0];
        int end = 0;
        int count = 0;
        List<String> result = new ArrayList<String>();
        for (int i=1;i<in.length;i++){
            if (in[i] -1 == in[i-1]){
                end = in[i];
                count++;
            }else{
                end = in[i-1];
                if (count > 0){
                    result.add(start +"-" + end);
                }else{
                    result.add("" + end);
                }
                start = in[i];
                count=0;
            }
        }
        if (count > 0){
            result.add(start +"-" + end);
        }else{
            result.add("" + end);
        }
        return result;
    }

    public static void main(String[] args){
        ArrayRange a = new ArrayRange();
        int[] in = new int[]{0,1,2,7,21,22,1098,1099};
        System.out.println(a.getRange(in));
    }
}

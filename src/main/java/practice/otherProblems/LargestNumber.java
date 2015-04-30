package practice.otherProblems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @author Yashraj R. Sontakke
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] NUM = new String[nums.length];

        for(int i=0; i<nums.length; i++){
            NUM[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(NUM, new Comparator<String>() {
            public int compare(String left, String right) {
                String leftRight = left.concat(right);
                String rightLeft = right.concat(left);
                return rightLeft.compareTo(leftRight);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : NUM){
            sb.append(s);
        }
        java.math.BigInteger result = new java.math.BigInteger(sb.toString());
        return result.toString();
    }

    public static void main(String[] args){
        LargestNumber l = new LargestNumber();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(l.largestNumber(nums));
    }
}

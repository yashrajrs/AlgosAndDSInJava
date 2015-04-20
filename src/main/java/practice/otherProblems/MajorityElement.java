package practice.otherProblems;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than (n/2) times.

 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author Yashraj R. Sontakke
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        if(num.length == 1){
            return num[0];
        }
        Arrays.sort(num);
        return num[num.length/2];
    }

    public static void main(String[] args){
        MajorityElement m = new MajorityElement();
        int[] input = {1,2,3,3,3};
        System.out.println(m.majorityElement(input));
    }
}

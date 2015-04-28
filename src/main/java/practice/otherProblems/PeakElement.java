package practice.otherProblems;

import java.util.Arrays;
import java.util.List;

/**
 * A peak element is an element that is greater than its neighbors.

 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 * You may imagine that num[-1] = num[n] = -∞.

 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 * click to show spoilers.

 * Note:
 * Your solution should be in logarithmic complexity.
 *
 * @author Yashraj R. Sontakke
 */
public class PeakElement {

    public int findPeakElement1(List<Integer> nums) {
        int max = nums.get(0);
        int index = 0;

        for(int i=1;i < nums.size()-1;i++){
            int prev = nums.get(i-1);
            int curr = nums.get(i);
            int next = nums.get(i+1);

            if(curr > prev && curr > next && curr > max){
                max = curr;
                index = i;
            }
        }
        if(nums.get(nums.size()-1) > max){
            return nums.size()-1;
        }
        return index;
    }

    public int findPeakElement(int[] nums) {
        int max = nums[0];
        int index = 0;

        for(int i=1;i < nums.length-1;i++){
            int prev = nums[i-1];
            int curr = nums[i];
            int next = nums[i+1];

            if(curr > prev && curr > next && curr > max){
                max = curr;
                index = i;
            }
        }
        if(nums[nums.length-1] > max){
            return nums.length-1;
        }
        return index;
    }

    public static void main(String[] args){
        PeakElement p = new PeakElement();
        int[] input = {1, 2, 3, 1};
        System.out.println(p.findPeakElement(input));
    }

}

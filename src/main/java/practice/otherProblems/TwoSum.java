package practice.otherProblems;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 * You may assume that each input would have exactly one solution.

 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * @author Yashraj R. Sontakke
 */
public class TwoSum {

        public int[] twoSum(int[] numbers, int target) {
            int[] output = new int[2];
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<numbers.length;i++){
                if(map.get(target - numbers[i]) != null){
                    output[0] = map.get(target - numbers[i]);
                    output[1] = i;
                    return output;
                }else{
                    map.put(numbers[i], i);
                }
            }
            output[0] = -1;
            output[1] = -1;
            return output;

        }

    public static void main(String[] args){
        TwoSum t  = new TwoSum();
        int[] input = {2,7,11,15};
        int[] output = t.twoSum(input,9);
        System.out.println(output[0] + " " + output[1]);
    }

}

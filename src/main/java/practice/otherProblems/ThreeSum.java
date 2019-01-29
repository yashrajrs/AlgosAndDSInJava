package practice.otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},

 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * @author Yashraj R. Sontakke
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length < 3){
            return result;
        }
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i==0 || num[i] > num[i-1]){
                int negate = -num[i];

                int start = i+1;
                int end = num.length-1;

                while(start < end){
                    if(num[start] + num[end] == negate){
                        List<Integer> list = Arrays.asList(num[i], num[start], num[end]);
                        result.add(list);
                        start++;
                        end--;
                        // handle duplicates
                        while(start < end && num[end] == num[end+1]){
                            end--;
                        }
                        while(start < end && num[start] == num[start-1]){
                            start++;
                        }
                    }else if(num[start] + num[end] < negate){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        ThreeSum t = new ThreeSum();
        int[] input = {-1, 0, 1, 2, -1, -4};
        System.out.println(t.threeSum(input).toString());
    }
}

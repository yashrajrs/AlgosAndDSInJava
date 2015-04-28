package practice.otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target
 *  Find all unique quadruplets in the array which gives the sum of target.

 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 * @author Yashraj R. Sontakke
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        if(num.length < 4){
            return result;
        }

        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            for(int j = i+1; j< num.length; j++){
                int k = j+1;
                int l = num.length-1;
                while(k < l){
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if(sum < target){
                        k++;
                    }else if (sum > target){
                        l--;
                    }else{
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);
                        if(!hashSet.contains(temp)){
                            hashSet.add(temp);
                            result.add(temp);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        FourSum f = new FourSum();
        int[] input = {1, 0, -1, 0, -2, 2};
        System.out.println(f.fourSum(input, 0).toString());
    }
}

package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p/>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class SubSetsWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> prev = new ArrayList<List<Integer>>();

        for (int i = nums.length - 1; i >= 0; i--) {

            if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
                prev = new ArrayList<List<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            for (List<Integer> temp : prev) {
                temp.add(0, nums[i]);
            }

            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                prev.add(temp);
            }

            for (List<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }
        result.add(new ArrayList<Integer>());
        return result;
    }


    public static void main(String[] args){
        SubSetsWithDuplicates s = new SubSetsWithDuplicates();
        int[] input = {1, 2, 2 };
        System.out.println(s.subsetsWithDup(input));

        int[] input1 = {1, 2, 3 };
        System.out.println(s.subsetsWithDup(input1));
    }
}

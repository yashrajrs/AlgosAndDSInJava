package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 * @author Yashraj R. Sontakke
 */
public class Permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permutations(nums, 0, result);
        return result;
    }

    public void permutations(int[] nums, int index, List<List<Integer>> result) {
        if (index >= nums.length) {
            List<Integer> list = convert(nums);
            System.out.println(list);
            if (!result.contains(list)) {
                result.add(list);
            }
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permutations(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    private List<Integer> convert(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutation2 p = new Permutation2();
//        int[] nums = {1, 1, 2};
//        System.out.println(p.permuteUnique(nums).toString());

        int[] nums1 = {1, 2, 3};
        System.out.println(p.permuteUnique(nums1).toString());
    }
}

package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (List<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }
            for (List<Integer> a : temp) {
                a.add(num);
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(num);
            temp.add(list);
            result.addAll(temp);
        }
        result.add(new ArrayList<Integer>());
        return result;
    }


    public List<List<Integer>> subsets1(int[] nums) {
       if (nums == null) {
            return  null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int num: nums) {
            List<List<Integer>> list = new ArrayList<>();
            for(List<Integer> temp: result) {
                list.add(new ArrayList<>(temp));
            }
            for(List<Integer> temp: list) {
                temp.add(num);
            }
            list.add(Arrays.asList(num));
            result.addAll(list);
        }
        result.add(new ArrayList<>());
        return result;
    }

    public static void main(String[] args){
        SubSets s = new SubSets();
        int[] input = {1, 2, 3 };
        System.out.println(s.subsets(input));
        System.out.println(s.subsets1(input));
    }
}

package practice.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * @author Yashraj R. Sontakke
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, current, result);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (List<Integer> temp : result){
            set.add(temp);
        }
        result.clear();
        result.addAll(set);

        return result;
    }

    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i+1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        int[] input = {10,1,2,7,6,1,5};
        System.out.println(c.combinationSum2(input, 8).toString());
    }
}

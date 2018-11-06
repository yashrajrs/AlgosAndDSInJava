package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes two arguments one array of integers that ranges between 0 and 9 and second the target sum(again integer). It produces all permutations strings of the input digits that equals the target sum.
 * For example, if input is array 2, 3, 5 and target sum is 10, then the output should be:
 * 22222 because 2+2+2+2+2 = ,10
 * 2323 as 2+3+2+3 = 10
 * 3232
 * 55
 * 2233
 * 3322
 * 532
 * 235
 * 352
 * etc.,
 *
 * @author Yashraj R. Sontakke
 */
public class PermutationSum {

    public List<List<Integer>> getPermutations(int[] in, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (in == null || in.length < 1) {
            return result;
        }
        Arrays.sort(in);
        ArrayList<Integer> current = new ArrayList<Integer>();
        getPermutations(in, target, 0, current, result);
        return result;
    }

    public void getPermutations(int[] in, int target, int val, ArrayList<Integer> current,
                                List<List<Integer>> result) {
        if (target == val) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (target < val) {
            return;
        }
        for (int i = 0; i < in.length; i++) {
            if (val + in[i] > target) {
                return;
            }
            current.add(in[i]);
            getPermutations(in, target, val + in[i], current, result);
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        PermutationSum p = new PermutationSum();
        int[] in = new int[]{2, 3, 5};
        System.out.println(p.getPermutations(in, 10).toString());
    }
}

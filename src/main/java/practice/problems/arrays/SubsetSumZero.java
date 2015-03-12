package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Given a set of number eg {5,3,1,8, -8,-4}
 * Print all subset which will sum up to ZERO
 * for eg {3,1,-4} {5,3,-8}, {8,-8}
 *
 * @author Yashraj R. Sontakke
 */
public class SubsetSumZero {
    public Set<ArrayList<Integer>> subSets = Sets.newHashSet();

    public void getSubSets(ArrayList<Integer> input, ArrayList<Integer> subset) {
        if (getValue(subset) == 0 && !subset.isEmpty()) {
            subSets.add(subset);
        }
        if (input.isEmpty()) {
            return;
        }

        for (Integer integer : input) {
            ArrayList<Integer> newInput = new ArrayList<Integer>(input);
            newInput.remove(integer);
            ArrayList<Integer> newSubSet = new ArrayList<Integer>(subset);
            newSubSet.add(integer);
            getSubSets(newInput, newSubSet);
        }
    }

    public Integer getValue(ArrayList<Integer> subset) {
        int value = 0;
        for (Integer integer : subset) {
            value += integer;
        }
        return value;
    }

    public static void main(String[] args) {
        SubsetSumZero subsetSumZero = new SubsetSumZero();
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 8, -8, -4));
        subsetSumZero.getSubSets(input, new ArrayList<Integer>());
        for (ArrayList<Integer> subset : subsetSumZero.subSets) {
            if (subset.size() < 4) {
                System.out.println(subset);
            }
        }
    }
}

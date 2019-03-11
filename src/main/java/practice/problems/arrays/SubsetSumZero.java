package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.*;

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

    public void subSets2(ArrayList<Integer> input) {
        Set<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        subSets2(input, 0, current, result);
        System.out.println(result);
    }

    public void subSets2(ArrayList<Integer> input, int pos, ArrayList<Integer> current,Set<ArrayList<Integer>> result ) {
        if(!current.isEmpty() && getValue(current) == 0) {
            result.add(new ArrayList<>(current));
        }
        if (pos == input.size()) {
            return;
        }
        for (int i=pos;i<input.size();i++) {
            current.add(input.get(i));
            subSets2(input, i+1, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetSumZero subsetSumZero = new SubsetSumZero();
//        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 8, -8, -4));
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 8, -8));
//        subsetSumZero.getSubSets(input, new ArrayList<Integer>());
//        for (ArrayList<Integer> subset : subsetSumZero.subSets) {
//            if (subset.size() < 4) {
//                System.out.println(subset);
//            }
//        }
        subsetSumZero.subSets2(input);
        System.out.println(subsetSumZero.getSubsets(input));
    }
    int sum = 0;
    public List<List<Integer>> getSubsets(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubs(nums, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void getSubs(List<Integer> nums, int index, int value, ArrayList<Integer> current, List<List<Integer>> result) {
        System.out.println(sum++);
        if(!current.isEmpty() && value == 0) {
            result.add(new ArrayList<Integer>(current));
        }
        for(int i=index;i<nums.size();i++) {
            current.add(nums.get(i));
            getSubs(nums, i+1, value + nums.get(i), current, result);
            current.remove(current.size()-1);
        }
    }



}

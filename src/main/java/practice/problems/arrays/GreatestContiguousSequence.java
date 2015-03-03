package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * You are given an array of integers (both positive and negative). Find the contiguous
 * sequence with the largest sum. Return the sum.
 * EXAMPLE
 * Input: 2, -8, 3, -2, 4, -10
 * Outputs (i.e., {3, -2, 4})
 *
 * @author Yashraj R. Sontakke
 */
public class GreatestContiguousSequence {

    public static Set<List<Integer>> sequences = Sets.newHashSet();


    public void getSequences(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                sequences.add(input.subList(i, j));
            }
        }
    }

    /**
     * First approach retrieves the elements for the value as well
     */
    public void getLongestContiguousSequence(ArrayList<Integer> input) {
        getSequences(input);

        if (sequences.isEmpty()) {
            return;
        }
        Integer value = Integer.MIN_VALUE;
        List<Integer> longestSequence = new ArrayList<Integer>();
        for (List<Integer> sequence : sequences) {
            Integer sequenceValue = getValue(sequence);
            if (value < sequenceValue) {
                value = sequenceValue;
                longestSequence = sequence;
            }
        }

        System.out.println(String.format("Value %d for %s", value, longestSequence.toString()));
    }

    public Integer getValue(List<Integer> input) {
        Integer value = 0;
        for (Integer integer : input) {
            value += integer;
        }
        return value;
    }

    /**
     * Second approach, retrieves just the value
     */
    public void getSum(ArrayList<Integer> input) {
        int maxSum = 0;
        int sum = 0;
        for (Integer integer : input) {
            sum += integer;
            if (maxSum < sum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Max value = " + maxSum);

    }

    public static void main(String[] args) {
        GreatestContiguousSequence greatestContiguousSequence = new GreatestContiguousSequence();
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(2, -8, 3, -2, 4, -10));
        greatestContiguousSequence.getLongestContiguousSequence(input);
        greatestContiguousSequence.getSum(input);
    }
}

package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Finds the length of the largest increasing sub sequence of the input list provided
 *
 * @author Yashraj R. Sontakke
 */
public class LongestIncreasingSubSequence {


    public static Set<ArrayList<Integer>> sequences = Sets.newHashSet();


    public void subSequences(ArrayList<Integer> input, ArrayList<Integer> currentSequence) {

        if (input.isEmpty()) {
            sequences.add(currentSequence);
            return;
        }


        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> currentInput = new ArrayList<Integer>(input.subList(i + 1, input.size()));
            if (currentSequence.get(currentSequence.size() - 1) < input.get(i)) {
                ArrayList<Integer> tempCurrentSequence = new ArrayList<Integer>(currentSequence);
                tempCurrentSequence.add(input.get(i));
                subSequences(currentInput, tempCurrentSequence);
            } else {
                subSequences(currentInput, currentSequence);
            }

        }
        sequences.add(currentSequence);
    }

    public void findSubSequences(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> currentInput = new ArrayList<Integer>(input.subList(i + 1, input.size()));
            subSequences(currentInput, new ArrayList<Integer>(Arrays.asList(input.get(i))));
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence longestIncreasingSubsequence = new LongestIncreasingSubSequence();
//        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(10,22,9,33,21,50,41,60,80));
        longestIncreasingSubsequence.findSubSequences(input);
        ArrayList<Integer> largestSequence = new ArrayList<Integer>();

        for (ArrayList<Integer> list : longestIncreasingSubsequence.sequences) {

            if (largestSequence.size() < list.size()) {
                largestSequence = list;
            }
        }
        System.out.println(String.format("Largest increasing subSequence is %s of size %d", largestSequence.toString(), largestSequence.size()));
    }
}

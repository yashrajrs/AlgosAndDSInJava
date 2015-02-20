package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Generate all permutations of given sequence of elements.
 * Return a list of all distinct permutations.
 * <p/>
 * E.g.
 * generate([1, 2, 3]) -> [1, 2, 3], [1, 3, 2], [2, 3, 1], [2, 1, 3], [3, 1, 2], [3, 2, 1]
 *
 * @author Yashraj R. Sontakke
 */
public class Permutations {

    public Set<ArrayList<Integer>> sequences = Sets.newHashSet();

    public void compute(ArrayList<Integer> currentSequence, ArrayList<Integer> input) {
        if (input.isEmpty()) {
            if (currentSequence.size() == 3) {
                sequences.add(currentSequence);
            }
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> tempCurrentSequence = new ArrayList<Integer>(currentSequence);
            tempCurrentSequence.add(input.get(i));
            ArrayList<Integer> currentInput = new ArrayList<Integer>(input);
            currentInput.remove(i);
            compute(tempCurrentSequence, currentInput);
        }
    }


    public void compute(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> currentInput = new ArrayList<Integer>(input);
            currentInput.remove(i);
            compute(new ArrayList<Integer>(Arrays.asList(input.get(i))), currentInput);
        }
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.compute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println(permutations.sequences.toString());
    }

}

package practice.problemSolving.recursion;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Write a method to compute all permutations of a string
 *
 * @author Yashraj R. Sontakke
 */
public class PermutationsString_9_5 {
    public Set<ArrayList<Character>> permutations = Sets.newHashSet();

    public void getPermutations(ArrayList<Character> input, ArrayList<Character> currentPerm) {
        if (input.isEmpty()) {
            permutations.add(currentPerm);
            return;
        }
        for (Character c : input) {
            ArrayList<Character> newInput = new ArrayList<Character>(input);
            ArrayList<Character> newPerm = new ArrayList<Character>(currentPerm);
            newPerm.add(c);
            newInput.remove(c);
            getPermutations(newInput, newPerm);
        }
    }

    public void getPermutations(ArrayList<Character> input) {
        permutations = Sets.newHashSet();
        if (input == null || input.isEmpty()) {
            return;
        }
        getPermutations(input, new ArrayList<Character>());
    }

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<Character>(Arrays.asList('A', 'B', 'C'));
        PermutationsString_9_5 permutationsString = new PermutationsString_9_5();
        permutationsString.getPermutations(input);

        System.out.println(permutationsString.permutations.toString());
    }

}

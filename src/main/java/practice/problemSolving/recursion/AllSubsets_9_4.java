package practice.problemSolving.recursion;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Write a method to return all subsets of a set.
 *
 * @author Yashraj R. Sontakke
 */
public class AllSubsets_9_4 {
    public Set<ArrayList<Integer>> subsets = Sets.newHashSet();


    public void getSubSets(ArrayList<Integer> input, ArrayList<Integer> currentSet) {
        if (input.isEmpty()) {
            subsets.add(currentSet);
            return;
        }

        ArrayList<Integer> newInput = new ArrayList<Integer>(input);
        ArrayList<Integer> newSet = new ArrayList<Integer>(currentSet);
        newSet.add(newInput.get(0));
        newInput.remove(0);

        getSubSets(newInput, currentSet);
        getSubSets(newInput, newSet);
    }

    public void getSS(ArrayList<Integer> input, ArrayList<Integer> currentInput, Set<
            ArrayList<Integer>> subsets){
        if(input.isEmpty()){
            subsets.add(currentInput);
            return;
        }
        ArrayList<Integer> newCurrentInput = new ArrayList<Integer>(currentInput);
        ArrayList<Integer> newInput = new ArrayList<Integer>(input);
        currentInput.add(input.get(0));
        newInput.remove(0);
        getSS(newInput, currentInput, subsets);
        getSS(newInput, newCurrentInput, subsets);
    }



    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        AllSubsets_9_4 allSubsets = new AllSubsets_9_4();
        allSubsets.getSubSets(input, new ArrayList<Integer>());

        System.out.println(allSubsets.subsets.toString());

        Set<ArrayList<Integer>> subSets = Sets.newHashSet();
        allSubsets.getSS(input, new ArrayList<Integer>(),subSets);
        System.out.println(subSets.toString());
    }
}

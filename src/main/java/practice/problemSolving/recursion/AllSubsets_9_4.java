package practice.problemSolving.recursion;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public List<List<Integer>> subsets(int[] input){
        if (input == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(input);
        for(int num : input){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (List<Integer> list: result){
                temp.add(new ArrayList<Integer>(list));
            }
            for (List<Integer> list :temp){
                list.add(num);
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(num);
            temp.add(list);
            result.addAll(temp);
        }
        result.add(new ArrayList<Integer>());
        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        AllSubsets_9_4 allSubsets = new AllSubsets_9_4();
        allSubsets.getSubSets(input, new ArrayList<Integer>());

        System.out.println(allSubsets.subsets.toString());

        Set<ArrayList<Integer>> subSets = Sets.newHashSet();
        allSubsets.getSS(input, new ArrayList<Integer>(),subSets);
        System.out.println(subSets.toString());

        int[] input1 = {1,2,3};
        System.out.println(allSubsets.subsets(input1));
    }
}

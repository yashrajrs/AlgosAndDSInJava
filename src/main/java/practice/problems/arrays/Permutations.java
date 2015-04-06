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


    public void compute1(ArrayList<Integer> currentSequence, ArrayList<Integer> input) {
        if (input.isEmpty()) {
            if (currentSequence.size() == 3) {
                sequences.add(currentSequence);
            }
            return;
        }
        for (Integer integer : input) {
            ArrayList<Integer> newInput = new ArrayList<Integer>(input);
            newInput.remove(integer);
            ArrayList<Integer> newCurrentSequence = new ArrayList<Integer>(currentSequence);
            newCurrentSequence.add(integer);
            compute1(newCurrentSequence, newInput);
        }
    }

    public void compute2(ArrayList<Integer> input, ArrayList<Integer> currentSequence, Set<ArrayList<Integer>> sequences){
        if (input.isEmpty()){
            sequences.add(currentSequence);
            return;
        }
        for (Integer integer : input){
            ArrayList<Integer> newInput = new ArrayList<Integer>(input);
            newInput.remove(integer);
            ArrayList<Integer> newCurrentSequence = new ArrayList<Integer>(currentSequence);
            newCurrentSequence.add(integer);
            compute2(newInput,newCurrentSequence,sequences);
        }
    }


    public void compute3(Integer[] array){
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        permutation(array,0,list);
        for (Integer[] arr : list){
            System.out.print(Arrays.asList(arr).toString() + " ");
        }
        System.out.println();
    }

    public void permutation(Integer[] array, int pos, ArrayList<Integer[]> list){
        if (array.length-pos==1){
            list.add(array.clone());
        }else{
            for (int i =pos;i<array.length;i++){
                swap(array,pos,i);
                permutation(array, pos+1, list);
                swap(array,pos,i);
            }
        }
    }

    public void swap(Integer[] array, int pos1,int pos2){
        int temp =array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.compute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println(permutations.sequences.toString());

        permutations.sequences = Sets.newHashSet();
        permutations.compute1(new ArrayList<Integer>(), new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println(permutations.sequences.toString());

        Set<ArrayList<Integer>> sequence = Sets.newHashSet();
        permutations.compute2(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), new ArrayList<Integer>(), sequence);
        System.out.println(sequence.toString());


        Integer[] array = {1,2,3};
        permutations.compute3(array);
    }

}

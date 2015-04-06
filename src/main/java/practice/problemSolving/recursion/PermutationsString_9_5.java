package practice.problemSolving.recursion;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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



    public void getPrems(ArrayList<Character> input, ArrayList<Character> currentInput, Set<ArrayList<Character>> permutations){
        if (input.isEmpty()){
            permutations.add(currentInput);
            return;
        }
        for (Character c : input){
            ArrayList<Character> newInput = new ArrayList<Character>(input);
            newInput.remove(c);
            ArrayList<Character> newCurrentInput = new ArrayList<Character>(currentInput);
            newCurrentInput.add(c);
            getPrems(newInput,newCurrentInput,permutations);
        }
    }

    public void getPerms1(char[] array, int pos, List<String> list){
        if (array.length == pos){
            list.add(new String(array));
        }
        for (int i = pos;i<array.length;i++){
            swap(array,i,pos);
            getPerms1(array, pos+1, list);
            swap(array,i,pos);
        }
    }

    public void swap(char[] array, int i, int j){
        Character temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<Character>(Arrays.asList('A', 'B', 'C'));
        PermutationsString_9_5 permutationsString = new PermutationsString_9_5();
        permutationsString.getPermutations(input);

        System.out.println(permutationsString.permutations.toString());

        Set<ArrayList<Character>> permutations = Sets.newHashSet();
        permutationsString.getPrems(input, new ArrayList<Character>(), permutations);
        System.out.println(permutations.toString());

        ArrayList<String> list = new ArrayList<String>();
        char[] array = {'A','B','C'};
        permutationsString.getPerms1(array,0,list);
        System.out.println(list.toString());
    }

}

package practice.problems.arrays;

import practice.algorithms.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Find a pair from a pair whose sum is a value provided.
 *
 * @author Yashraj R. Sontakke
 */
public class ArrayPairParticularSum {

    MergeSort mergeSort = new MergeSort();

    public void findPair(Integer[] input, Integer pairValue) {

        Integer[] sort = mergeSort.sort(input);
        ArrayList<Integer> sorted = new ArrayList<Integer>(Arrays.asList(sort));

        // First approach
//        for (Integer integer : sorted){
//            Integer value = pairValue - integer;
//            if (sorted.contains(value)){
//                System.out.println(String.format("The pair is {%d, %d}", integer, value));
//                return;
//            }
//        }
//        System.out.println("Cannot find pair for the value " + pairValue);


        // Second approach
        int i = 0, j = sort.length - 1;
        Integer left = sort[0];
        Integer right = sort[j];
        while (i < sort.length && j > 0) {
            System.out.println(String.format("Current pair is {%d, %d}", left, right));
            if (left + right == pairValue) {
                System.out.println(String.format("The pair is {%d, %d}", left, right));
                return;
            } else if (left + right > pairValue) {
                j--;
                right = sort[j];
            } else {
                i++;
                left = sort[i];
            }
        }
        System.out.println("Cannot find pair for the value " + pairValue);

    }

    public static void main(String[] args) {
        ArrayPairParticularSum arrayPairParticularSum = new ArrayPairParticularSum();
        Integer[] input = {9, 8, 7, 6, 5, 4, 3, 1, 2};
        arrayPairParticularSum.findPair(input, 4);
    }

}

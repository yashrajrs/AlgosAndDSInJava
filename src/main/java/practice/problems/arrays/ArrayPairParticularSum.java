package practice.problems.arrays;

import practice.algorithms.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Find a pair from a pair whose sum is a value provided.
 *
 * @author Yashraj R. Sontakke
 */
public class ArrayPairParticularSum {

    MergeSort mergeSort = new MergeSort();

    // First approach
    public void findPair(Integer[] input, Integer pairValue) {

        Integer[] sort = mergeSort.sort(input);
        ArrayList<Integer> sorted = new ArrayList<Integer>(Arrays.asList(sort));

        // First approach
        for (Integer integer : sorted) {
            Integer value = pairValue - integer;
            if (sorted.contains(value)) {
                System.out.println(String.format("The pair is {%d, %d}", integer, value));
            }
        }

    }

    // Second approach using hash map
    public void findPair1(Integer[] input, Integer pairValue) {

        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for (Integer integer : input) {
            hashMap.put(integer,integer);
        }

        for (Integer integer : hashMap.keySet()) {
            Integer value = pairValue - integer;
            if (hashMap.get(value)!=null) {
                System.out.println(String.format("The pair is {%d, %d}", integer, value));
            }
        }

    }

    // Third approach
    public void findPair2(Integer[] input, Integer pairValue) {

        Integer[] sort = mergeSort.sort(input);

        int i = 0, j = sort.length - 1;
        while (i < j) {
            int sum = sort[i] + sort[j];
            if (sum == pairValue) {
                System.out.println(String.format("The pair is {%d, %d}", sort[i], sort[j]));
                i++;
                j--;
            } else if (sum > pairValue) {
                j--;
            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) {
        ArrayPairParticularSum arrayPairParticularSum = new ArrayPairParticularSum();
        Integer[] input = {9, 8, 7, 6, 5, 4, 3, 1, 2};
        arrayPairParticularSum.findPair(input, 5);
        arrayPairParticularSum.findPair1(input, 5);
        arrayPairParticularSum.findPair2(input, 5);
    }

}

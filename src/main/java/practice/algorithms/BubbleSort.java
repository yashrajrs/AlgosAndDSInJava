package practice.algorithms;

import java.util.Arrays;

/**
 * Implements bubble sort.
 * Time complexity O(n2) and space complexity O(1).
 *
 * @author Yashraj R. Sontakke
 */
public class BubbleSort {

    public Integer[] sort(Integer[] input) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < input.length; i++) {
                if (input[i - 1] > input[i]) {
                    int temp = input[i];
                    input[i] = input[i - 1];
                    input[i - 1] = temp;
                    swapped = true;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        BubbleSort m = new BubbleSort();
        Integer[] input = {4, 2, 10, 3, 5, 1, 9, 7};
        Integer[] output = m.sort(input);
        System.out.println("Sorted = " + Arrays.asList(output).toString());
    }
}

package practice.algorithms;

import java.util.Arrays;

/**
 * Implements quick sort.
 * Time complexity worst case O(n2), average case O(nLogn) and space complexity O(logn).
 *
 * @author Yashraj R. Sontakke
 */
public class QuickSort {

    public void sort(Integer[] input, int left, int right) {

        int pivot = input[left + (right - left) / 2];

        int i = left;
        int j = right;

        while (i <= j) {

            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            sort(input, left, j);
        }
        if (i < right) {
            sort(input, i, right);
        }
    }

    private void swap(Integer[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


    public static void main(String[] args) {
        QuickSort m = new QuickSort();
        Integer[] input = {4, 2, 10, 3, 5, 1, 9, 7};
        m.sort(input, 0, input.length - 1);
        System.out.println("MERGED = " + Arrays.asList(input).toString());
    }
}

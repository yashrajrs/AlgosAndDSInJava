package practice.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implements radix sort.
 * Time complexity worst case O(kn) and space complexity O(k+n).
 *
 * @author Yashraj R. Sontakke
 */
public class RadixSort {

    public void sort(Integer[] input) {
        ArrayList<Integer>[] queue = new ArrayList[10];

        for (int i = 0; i < queue.length; i++) {
            queue[i] = new ArrayList<Integer>();
        }

        for (int j = 1; j <= 4; j++) {
            for (int i = 0; i < input.length; i++) {
                queue[getRadix(input[i], j)].add(input[i]);
            }

            int index = 0;
            for (int i = 0; i < queue.length; i++) {

                for (int k = 0; k < queue[i].size(); k++) {
                    input[index] = queue[i].get(k);
                    index++;
                }
                queue[i] = new ArrayList<Integer>();

            }
        }
    }

    public Integer getRadix(int number, int radix) {
        int result = (int) (number / (Math.pow(10, radix - 1))) % 10;
        return result;
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        Integer[] input = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567};
        radixSort.sort(input);
        System.out.println(Arrays.asList(input).toString());
    }
}

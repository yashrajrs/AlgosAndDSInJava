package practice.problems.arrays;

import java.util.TreeMap;

/**
 * Given an array of ages (integers) sorted lowest to highest, output the number of occurrences for each age.
 * For instance: [8,8,8,9,9,11,15,16,16,16] should output something like:
 * 8: 3
 * 9: 2
 * 11: 1
 * 15: 1
 * 16: 3
 * <p/>
 * This should be done in less than O(n).
 *
 * @author Yashraj R. Sontakke
 */
public class SortedArrayPrinting {

    public TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

    public void print(int[] a, int start, int end) {
        if (a[start] == a[end]) {
            if (map.containsKey(a[start])) {
                map.put(a[start], map.get(a[start]) + end - start + 1);
            } else {
                map.put(a[start], end - start + 1);
            }
        } else {
            print(a, start, (start + end) / 2);
            print(a, (start + end) / 2 + 1, end);
        }
    }

    public static void main(String[] args) {
        SortedArrayPrinting sortedArrayPrinting = new SortedArrayPrinting();
        int[] a = {8, 8, 8, 9, 9, 11, 15, 16, 16, 16};
        sortedArrayPrinting.print(a, 0, a.length - 1);

        System.out.println(sortedArrayPrinting.map.toString());
    }
}

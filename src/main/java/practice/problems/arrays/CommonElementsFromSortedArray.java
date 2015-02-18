package practice.problems.arrays;

import java.util.Set;
import java.util.TreeSet;

/**
 * There are 2 sorted sets.Find the common elements of those sets
 * e.g.
 * A={1,2,3,4,5,6}
 * B={5,6,7,8,9}
 * o/p C={5,6}
 * <p/>
 * Complexity should ne 0(n+m) where n and m is the size of the first and second set respectively
 * <p/>
 * Which data structure should be used to store the output
 *
 * @author Yashraj R. Sontakke
 */
public class CommonElementsFromSortedArray {

    public Set<Integer> getCommonElements(int[] a, int[] b) {
        Set<Integer> commonElements = new TreeSet<Integer>();
        int i = a.length - 1;
        int j = b.length - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] == b[j]) {
                commonElements.add(a[i]);
                i--;
                j--;
            } else if (a[i] > b[j]) {
                i--;
            } else {
                j--;
            }
        }

        return commonElements;
    }

    public static void main(String[] args) {
        CommonElementsFromSortedArray commonElementsFromSortedArray = new CommonElementsFromSortedArray();
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {5, 6, 7, 8, 9};
        System.out.println(commonElementsFromSortedArray.getCommonElements(a, b).toString());

        int[] c = {1, 3, 5, 6, 7, 8, 9};
        int[] d = {1, 4, 5, 5, 17, 81, 88, 99};
        System.out.println(commonElementsFromSortedArray.getCommonElements(c, d).toString());
    }
}

package practice.algorithms;

/**
 * Implements selection sort.
 * Time complexity O(nlog(n)) and space complexity depends.
 *
 * @author Yashraj R. Sontakke
 */
public class MergeSort {

    public Integer[] sort(final Integer[] a) {
        if (a.length == 1) {
            return a;
        }
        Integer[] half1 = new Integer[a.length / 2];
        int i1 = (a.length % 2 == 0) ? a.length / 2 : a.length / 2 + 1;
        Integer[] half2 = new Integer[i1];
        for (int i = 0; i < a.length / 2; i++) {
            half1[i] = a[i];
        }
        for (int i = 0; i < i1; i++) {
            half2[i] = a[i + a.length / 2];
        }
        Integer[] firstHalfSorted = sort(half1);
        Integer[] secondHalfSorted = sort(half2);
        return merge(firstHalfSorted, secondHalfSorted);

    }

    public Integer[] merge(final Integer[] a, final Integer[] b) {

        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }
        int i = 0, j = 0, k = 0;
        Integer[] c = new Integer[a.length + b.length];

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        return c;
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        Integer[] input = {4, 2, 10, 3, 5, 1, 9, 7};
        Integer[] output = m.sort(input);
        System.out.println("MERGED = " + output.toString());
    }
}

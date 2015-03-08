package practice.problemSolving.sortingAndSearching;

import java.util.Arrays;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order
 *
 * @author Yashraj R. Sontakke
 */
public class MergeTwoSortedArrays_11_1 {

    public void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastA + lastB - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexMerged--;
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexMerged--;
                indexB--;
            }
        }

        while (indexB >= 0) {
            a[indexMerged] = b[indexB];
            indexMerged--;
            indexB--;
        }

    }

    public static void main(String[] args) {
        MergeTwoSortedArrays_11_1 m = new MergeTwoSortedArrays_11_1();
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;
        int[] b = {2, 4, 6, 8, 10};

        m.merge(a, b, 5, 5);
        System.out.println(Arrays.toString(a));

    }
}

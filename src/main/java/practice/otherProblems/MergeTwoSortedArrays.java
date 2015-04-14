package practice.otherProblems;

import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 *
 * @author Yashraj R. Sontakke
 */
public class MergeTwoSortedArrays {
    public void merge(int A[], int m, int B[], int n) {
        int indexA = m-1;
        int indexB = n-1;
        int indexMerged = m + n - 1;

        while(indexA >=0 && indexB >=0){
            if(A[indexA] > B[indexB]){
                A[indexMerged] = A[indexA];
                indexMerged--;
                indexA--;
            }else{
                A[indexMerged] = B[indexB];
                indexMerged--;
                indexB--;
            }
        }
        while(indexB >= 0){
            A[indexMerged] = B[indexB];
            indexMerged--;
            indexB--;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays m = new MergeTwoSortedArrays();
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;
        int[] b = {2, 4, 6, 8, 10};

        m.merge(a, 5,b, 5);
        System.out.println(Arrays.toString(a));

    }
}

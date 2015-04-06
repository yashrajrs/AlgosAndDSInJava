package practice.otherProblems;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.

 * Do not allocate extra space for another array, you must do this in place with constant memory.

 * For example,
 * Given input array A = [1,1,2],

 * Your function should return length = 2, and A is now [1,2].
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] A) {
        if(A.length<2){
            return A.length;
        }
        int i =1;
        int j =0;
        while(i< A.length){
            if(A[i] == A[j]){
                i++;
            }else{
                j++;
                A[j] = A[i];
                i++;
            }
        }
        return j+1;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int[] a = {1,2,2,3,4};
        int b = r.removeDuplicates(a);
        printArray(a,b);

    }

    public static void printArray(int[] a, int length){
        for(int i=0;i<length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

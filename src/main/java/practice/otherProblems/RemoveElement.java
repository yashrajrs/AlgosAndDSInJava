package practice.otherProblems;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            if (A[0] != elem) {
                return A.length;
            } else {
                return 0;
            }
        }
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            if (A[left] != elem) {
                left++;
                continue;
            }
            if (A[right] == elem) {
                right--;
                continue;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        if (A[left] == elem) {
            return left;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] a = {1, 2, 2, 3, 4};
        int b = r.removeElement(a, 2);
        printArray(a, b);

    }

    public static void printArray(int[] a, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

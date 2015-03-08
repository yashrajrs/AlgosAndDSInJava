package practice.problemSolving.recursion;

/**
 * A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if
 * one exists, in array A.
 *
 * @author Yashraj R. Sontakke
 */
public class MagicIndexArray_9_3 {

    public Integer magicFast(int[] input, int start, int end) {
        if (start > end || start < 0 || end >= input.length) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (input[mid] == mid) {
            return mid;
        }
        if (input[mid] > mid) {
            return magicFast(input, start, mid - 1);
        } else {
            return magicFast(input, mid + 1, end);
        }
    }

    public Integer magicFastNonDistinct(int[] input, int start, int end) {
        if (start > end || start < 0 || end >= input.length) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = input[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }
        int leftIndex = Math.min(midValue, midIndex - 1);
        int left = magicFast(input, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midValue, midIndex + 1);
        int right = magicFast(input, rightIndex, end);
        return right;

    }

    public static void main(String[] args) {
        int[] input = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        MagicIndexArray_9_3 magicIndexArray = new MagicIndexArray_9_3();
        System.out.println(magicIndexArray.magicFast(input, 0, input.length - 1));

        int[] input1 = {-10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13};
        System.out.println(magicIndexArray.magicFastNonDistinct(input1, 0, input1.length - 1));
    }
}

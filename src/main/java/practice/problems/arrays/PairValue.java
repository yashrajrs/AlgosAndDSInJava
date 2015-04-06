package practice.problems.arrays;

import java.util.Arrays;

/**
 * Returns true if there is any pair of numbers in the internal data structure which
 * have sum @param val, and false otherwise.
 * For example, if the numbers 1, -2, 3, and 6 had been stored,
 * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
 *
 * @author Yashraj R. Sontakke
 */
public class PairValue {

    public boolean isSum(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PairValue pairValue = new PairValue();
        int[] array = {1,-2,3,6};
        System.out.println(pairValue.isSum(array,4));
        System.out.println(pairValue.isSum(array,-1));
        System.out.println(pairValue.isSum(array,9));
        System.out.println(pairValue.isSum(array,10));
        System.out.println(pairValue.isSum(array,5));
        System.out.println(pairValue.isSum(array,0));
    }
}

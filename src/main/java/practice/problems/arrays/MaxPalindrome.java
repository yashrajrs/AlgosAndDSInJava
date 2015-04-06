package practice.problems.arrays;

/**
 * Write a function to compute the maximum length palindromic sub-sequence of an array.
 * A palindrome is a sequence which is equal to its reverse.
 * A sub-sequence of an array is a sequence which can be constructed by removing elements of the array.
 * Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's)
 *
 * @author Yashraj R. Sontakke
 */
public class MaxPalindrome {

    public Integer getMax(int[] input, int i, int j, int[][] mem) {
        if (i > j) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        } else if (input[i] == input[j]) {
            mem[i][j] = 2 + getMax(input, i + 1, j - 1, mem);
            return mem[i][j];
        } else {
            mem[i][j] =Math.max(getMax(input, i, j-1, mem), getMax(input, i+1, j, mem));
            return mem[i][j];
        }
    }

    public Integer getMax(int[] input) {
        int[][] mem = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            mem[i][i] = 1;
        }
        return getMax(input, 0, input.length - 1, mem);
    }

    public static void main(String[] args) {
        MaxPalindrome maxPalindrome = new MaxPalindrome();
        int[] input = {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};
        System.out.println(maxPalindrome.getMax(input));

    }
}

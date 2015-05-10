package practice.otherProblems.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p/>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 * @author Yashraj R. Sontakke
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(nums[i] * maxLocal, nums[i]), nums[i] * minLocal);
            minLocal = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }

    public static void main(String[] args){
        MaxProductSubArray m = new MaxProductSubArray();
        int[] input = {2,3,-2,4};
        System.out.println(m.maxProduct(input));
    }
}

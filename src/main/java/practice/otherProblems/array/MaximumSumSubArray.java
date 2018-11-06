package practice.otherProblems.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p/>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * <p/>
 * click to show more practice.
 * <p/>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author Yashraj R. Sontakke
 */
public class MaximumSumSubArray {

    public int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(newSum + nums[i], nums[i]);
            max = Math.max(max, newSum);
        }
        return max;
    }

    public static void main(String[] args){
        MaximumSumSubArray m = new MaximumSumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(nums));
    }
}

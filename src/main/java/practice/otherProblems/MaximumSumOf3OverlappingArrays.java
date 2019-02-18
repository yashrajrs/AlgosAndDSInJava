package practice.otherProblems;

/**
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

 Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

 Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

 Example:
 Input: [1,2,1,2,6,7,5,1], 2
 Output: [0, 3, 5]
 Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 */
public class MaximumSumOf3OverlappingArrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        int[] W = new int[nums.length-K+1];
        int sum=0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if (i>=K) {
                sum -= nums[i-K];
            }
            if (i>=K-1) {
                W[i-K+1] = sum;
            }
        }
        int[] left = new int[W.length];
        int best = 0;
        for(int i=0;i<W.length;i++) {
            if (W[i] > W[best]) {
                best = i;
            }
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length-1;
        for(int j=W.length-1;j>=0;j--) {
            if (W[j] > W[best]) {
                best = j;
            }
            right[j] = best;
        }
        int[] res = new int[]{-1,-1,-1};
        for (int j=K;j<W.length-K;j++) {
            int i = left[j-K], k = right[j+K];
            if (res[0] == -1 || W[i] + W[j] + W[k] > W[res[0]] + W[res[1]] + W[res[2]]) {
                res[0] = i;
                res[1] = j;
                res[2] = k;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumSumOf3OverlappingArrays m = new MaximumSumOf3OverlappingArrays();
        int[] nums = {1,2,1,2,6,7,5,1};
//        System.out.println(m.maxSumOfThreeSubarrays(nums, 2));

        int[] nums1 = {18,11,14,7,16,4,18,11,4,8};
        System.out.println(m.maxSumOfThreeSubarrays(nums1, 2));
    }

}

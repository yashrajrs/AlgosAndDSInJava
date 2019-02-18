package practice.otherProblems.array;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 Note:
 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinousSubarraySum {
    public boolean checkSubarraySum2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int start = 0;start<nums.length;start++) {
            for (int end = start+1; end<nums.length;end++) {
                int summ = sum[end] - sum[start] + nums[start];
                if (summ == k || (k!=0 && summ%k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkSubarraySum(int[] nums, int k) {

        for(int i=0;i<nums.length;i++) {
            int sum = nums[i];
            int j=i+1;
            while(j<nums.length) {
                if(sum == k) {
                    return true;
                }
                sum+= nums[j];
                j++;
            }
            if (sum == k && i != nums.length-1) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum1(int[] nums, int k) {


        for(int i=0;i<nums.length;i++) {
            int sum = nums[i];
            int j=i+1;
            while (j < nums.length) {
                if(sum%k == 0 && j-1 >=1) {
                    return true;
                }
                sum+= nums[j];
                j++;
            }
            if (sum%k == 0 && i!= nums.length-1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinousSubarraySum c = new ContinousSubarraySum();
        int[] nums1 = {23, 2, 4, 6, 7};
        System.out.println(c.checkSubarraySum(nums1, 6));
        System.out.println(c.checkSubarraySum(nums1, 42));
    }
}

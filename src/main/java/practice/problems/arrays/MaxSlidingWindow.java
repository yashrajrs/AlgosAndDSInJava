package practice.problems.arrays;

/**
 * Created by yashraj on 3/7/19.
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n*k == 0) {
            return new int[0];
        }
        if(k==1) {
            return nums;
        }
        int[] left = new int[n];
        left[0] = nums[0];

        for(int i=1;i<n;i++) {
            if(i%k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }
        }
        int[] right = new int[n];
        right[n-1] = nums[n-1];

        for(int j=n-2;j>=0;j--) {
            if((j+1)%k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }
        int[] output = new int[n-k+1];
        for(int i=0;i< output.length;i++) {
            output[i] = Math.max(left[i+k-1], right[i]);
        }
        return output;
    }
}

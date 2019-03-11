package practice.problems.others;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 */
public class FirstMissingPositiveNumber {

    public int firstMissingPositive(int[] nums) {
        int i=0;
        while (i< nums.length) {
            if(nums[i] == i+1 || nums[i] <=0 || nums[i] > nums.length) {
                i++;
            } else if (nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        i=0;
        while (i<nums.length && nums[i] == i+1) {
            i++;
        }
        return i+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositiveNumber f = new FirstMissingPositiveNumber();
        int[] nums1 = {1, 2, 0};
        int[] nums2 = {3, 4, -1, 1};
        int[] nums3 = {7,8,9,11,12};

        System.out.println(f.firstMissingPositive(nums1));
        System.out.println(f.firstMissingPositive(nums2));
        System.out.println(f.firstMissingPositive(nums3));
    }
}

package practice.otherProblems.array;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * @author Yashraj R. Sontakke
 */
public class StartAndEndIndexOfANumber {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = searchLeft(nums, target);
        res[1] = searchRight(nums, target);
        return res;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left  <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0) {
                    return mid;
                }
                if(nums[mid-1] == target){
                    right = mid-1;
                }else{
                    return mid;
                }
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    private int searchRight(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left  <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length-1) {
                    return mid;
                }
                if(nums[mid+1] == target){
                    left = mid+1;
                }else{
                    return mid;
                }
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        StartAndEndIndexOfANumber s = new StartAndEndIndexOfANumber();
        int[] nums = {5, 7, 7, 8, 8, 10};

        int[] res1 = s.searchRange(nums, 8);
        System.out.println(res1[0] + " " + res1[1]);

        int[] nums2 = {5, 7, 7, 7, 8, 10};

        int[] res2 = s.searchRange(nums2, 8);
        System.out.println(res2[0] + " " + res2[1]);

        int[] nums3 = {5, 7, 7, 7, 8, 10};

        int[] res3 = s.searchRange(nums3, 6);
        System.out.println(res3[0] + " " + res3[1]);

        int[] nums4 = {1,4};

        int[] res4 = s.searchRange(nums4, 4);
        System.out.println(res4[0] + " " + res4[1]);
    }
}

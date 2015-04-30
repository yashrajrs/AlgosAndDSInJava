package practice.otherProblems.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 * Find the minimum element.

 * You may assume no duplicate exists in the array.
 *
 * @author Yashraj R. Sontakke
 */
public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length -1);
    }

    public int findMin(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        if((right - left) == 1){
            return Math.min(nums[left], nums[right]);
        }
        if(nums[left] < nums[right]){
            return nums[left];
        }
        int mid = left + (right - left)/2;
        if(nums[mid] > nums[left]){
            return findMin(nums, mid, right);
        }else{
            return findMin(nums, left, mid);
        }
    }

    public static void main(String[] args){
        FindMinInRotatedSortedArray f = new FindMinInRotatedSortedArray();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(f.findMin(input));

        int[] input1 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(f.findMin(input1));

        int[] input2 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(f.findMin(input2));
    }
}

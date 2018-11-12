package practice.otherProblems.strings;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]
 Note: Please solve it without division and in O(n).

 Follow up:
 Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfSelfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length-1] = 1;
        for (int i= nums.length-2;i>=0;i--) {
            result[i] = nums[i+1] * result[i+1];
        }

        int left = 1;
        for (int i=0;i<nums.length;i++) {
            result[i] = result[i]*left;
            left =left*nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        ProductOfSelfArrayExceptSelf p = new ProductOfSelfArrayExceptSelf();
        int[] input = {1,2,3,4};
//        p.productExceptSelf(input);

        int[] input1 = {4,3,2};
        p.productExceptSelf(input1);
    }
}

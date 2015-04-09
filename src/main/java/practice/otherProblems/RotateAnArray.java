package practice.otherProblems;

/**
 * Rotate an array of n elements to the right by k steps.

 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.



 * Hint:
 * Could you do it in-place with O(1) extra space?
 *
 * @author Yashraj R. Sontakke
 */
public class RotateAnArray {


    public void rotate1(int[] nums, int k) {
        if(nums == null || k < 0){
            throw  new IllegalStateException("Wrong input");
        }
        int temp;
        for(int i=0;i<k;i++){
            temp = nums[nums.length-1];

            for(int j=nums.length-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args){
        RotateAnArray r = new RotateAnArray();
        int[] nums = {1,2,3,4,5,6,7};
        r.rotate1(nums,3);

        for(int i=0;i<nums.length;i++){
            System.out.print( nums[i] + " ");
        }
        System.out.println();
    }
}

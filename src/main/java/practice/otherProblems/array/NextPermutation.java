package practice.otherProblems.array;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 *
 * @author Yashraj R. Sontakke
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int p = 0;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                p = i;
                break;
            }
        }

        int q =0;
        for(int i = nums.length-1;i>p;i--){
            if(nums[i] > nums[p]){
                q = i;
                break;
            }
        }

        if(p == 0 && q ==0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;

        if(p < nums.length-1){
            reverse(nums, p+1, nums.length-1);
        }
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        NextPermutation n = new NextPermutation();
        int[] a = {1, 2, 3};
        n.nextPermutation(a);
        System.out.println( a[0] + " " + a[1] + " " + a[2]);

        int[] b = {3, 2, 1};
        n.nextPermutation(b);
        System.out.println( b[0] + " " + b[1] + " " + b[2]);


        int[] c = {1, 1, 5};
        n.nextPermutation(c);
        System.out.println( c[0] + " " + c[1] + " " + c[2]);


    }


}

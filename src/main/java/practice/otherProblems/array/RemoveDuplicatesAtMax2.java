package practice.otherProblems.array;

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5,
 with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveDuplicatesAtMax2 {

    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int prev = 1;
        int cur = 2;
        while(cur < nums.length){
            if(nums[cur] == nums[prev] && nums[cur] == nums[prev-1]){
                cur++;
            }else{
                prev++;
                nums[prev] = nums[cur];
                cur++;
            }
        }
        return prev + 1;
    }

    public static void main(String[] args){
        RemoveDuplicatesAtMax2 r = new RemoveDuplicatesAtMax2();
        int[] input = {1,1,1,2,2,3};
        int end = r.removeDuplicates(input);

        for(int i=0;i<end;i++){
            System.out.print(input[i] + " ");
        }
    }
}

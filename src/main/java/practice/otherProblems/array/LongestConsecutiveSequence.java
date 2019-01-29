package practice.otherProblems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Your algorithm should run in O(n) complexity.

 Example:

 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for(Integer num:nums) {
            set.add(num);
        }

        for(Integer num:nums) {
            int left = num-1;
            int right = num+1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }


    public static void main(String[] args){
        LongestConsecutiveSequence d = new LongestConsecutiveSequence();
        int[] num = {100, 4, 200, 1, 3, 2};
        System.out.println(d.longestConsecutive(num));
    }
}

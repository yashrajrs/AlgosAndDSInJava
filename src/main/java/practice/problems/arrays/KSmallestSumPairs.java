package practice.problems.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:

 Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 Output: [[1,2],[1,4],[1,6]]
 Explanation: The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:

 Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 Output: [1,1],[1,1]
 Explanation: The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:

 Input: nums1 = [1,2], nums2 = [3], k = 3
 Output: [1,3],[2,3]
 Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class KSmallestSumPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) {
            return result;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((n1, n2) -> {
            int sum1 = n1[0] + n1[1];
            int sum2 = n2[0] + n2[1];
            return sum1 - sum2;
        });

        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                int[] temp = {nums1[i],nums2[j]};
                queue.offer(temp);
            }
        }
        for(int i=0;i<k && !queue.isEmpty();i++) {
            result.add(queue.poll());
        }
        return result;
    }
}

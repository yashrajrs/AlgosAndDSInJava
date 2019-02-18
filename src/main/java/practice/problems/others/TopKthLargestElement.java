package practice.problems.others;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4

 */
public class TopKthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int num:nums) {
            priorityQueue.add(num);
        }
        while(priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(final String[] args) {
        TopKthLargestElement t = new TopKthLargestElement();
        int[] nums1 = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};

        System.out.println(t.findKthLargest(nums1, 2));
        System.out.println(t.findKthLargest(nums2, 4));
    }
}

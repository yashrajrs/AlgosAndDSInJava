package practice.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yashraj on 3/8/19.
 */
public class KthLargestElementInStream {
    PriorityQueue<Integer> queue;
    int k;


    public KthLargestElementInStream(int k, int[] nums) {
        this.queue = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        for(int num: nums) {
            queue.offer(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k-1;i++) {
            list.add(queue.poll());
        }
        int large = queue.peek();
        for(int num:list) {
            queue.offer(num);
        }
        return large;
    }
}

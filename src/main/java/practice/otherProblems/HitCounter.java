package practice.otherProblems;

import java.util.LinkedList;

/**
 * Created by yashraj on 2/26/19.
 */
public class HitCounter {
    LinkedList<Integer> queue;
    private final Integer duration = 300;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (queue.size() > 0 && timestamp - queue.peek() >= duration) {
            while (queue.size() > 0 && timestamp - queue.peek() >= duration) {
                queue.poll();
            }
        }
        return queue.size();
    }
}

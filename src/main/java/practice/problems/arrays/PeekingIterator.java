package practice.problems.arrays;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by yashraj on 3/9/19.
 */
public class PeekingIterator implements Iterator<Integer> {
    LinkedList<Integer> queue;

    public PeekingIterator(Iterator<Integer> iterator) {
        queue = new LinkedList<>();
        // initialize any member here.
        while(iterator.hasNext()) {
            queue.offer(iterator.next());
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

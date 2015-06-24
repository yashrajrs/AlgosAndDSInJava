package practice.problems.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * @author Yashraj R. Sontakke
 */
public class ImplementStackUsingQueues {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.isEmpty()) {
            return;
        }
        if (queue1.size() == 1) {
            queue1.remove();
            return;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        queue1.remove();
        queue1 = queue2;
        queue2 = new LinkedList<Integer>();

    }

    // Get the top element.
    public int top() {
        if (queue1.isEmpty()) {
            return -1;
        }
        if (queue1.size() == 1) {
            return queue1.peek();
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int top = queue1.peek();
        queue2.add(queue1.remove());
        queue1 = queue2;
        queue2 = new LinkedList<Integer>();
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues i = new ImplementStackUsingQueues();
        i.push(1);
        System.out.println(i.top());
        i.push(2);
        System.out.println(i.top());
        i.push(3);
        System.out.println(i.top());
        i.pop();
        System.out.println(i.top());
        System.out.println(i.empty());
        i.pop();
        System.out.println(i.top());
        System.out.println(i.empty());
        i.pop();
        System.out.println(i.top());
        System.out.println(i.empty());
    }

}

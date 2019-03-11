package practice.problems.stack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.

 FreqStack has two functions:

 push(int x), which pushes an integer x onto the stack.
 pop(), which removes and returns the most frequent element in the stack.
 If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.


 Example 1:

 Input:
 ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 Output: [null,null,null,null,null,null,null,5,7,5,4]
 Explanation:
 After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

 pop() -> returns 5, as 5 is the most frequent.
 The stack becomes [5,7,5,7,4].

 pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 The stack becomes [5,7,5,4].

 pop() -> returns 5.
 The stack becomes [5,7,4].

 pop() -> returns 4.
 The stack becomes [5,7].


 Note:

 Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
 It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
 The total number of FreqStack.push calls will not exceed 10000 in a single test case.
 The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
 The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.

 */
public class FreqStack {
    Stack<Integer> stack;
    Map<Integer, Integer> map;

    public FreqStack() {
        stack = new Stack<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        stack.push(x);
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }
        int max = Collections.max(map.values());
        Stack<Integer> tempStack = new Stack<>();
        int result = -1;
        while(!stack.isEmpty()) {
            if(map.get(stack.peek()) == max) {
                result = stack.peek();
                if(max == 1) {
                    map.remove(result);
                } else {
                    map.put(result, map.get(result)-1);
                }
                stack.pop();
                break;
            }
            tempStack.push(stack.pop());
        }
        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        FreqStack f = new FreqStack();
        f.push(5);
        f.push(7);
        f.push(5);
        f.push(7);
        f.push(4);
        f.push(5);
        System.out.println(f.pop()); // 5
        System.out.println(f.pop()); // 7
        System.out.println(f.pop()); // 5
        System.out.println(f.pop()); // 4
    }
}


package practice.otherProblems;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author Yashraj R. Sontakke
 */
public class StackWithMin {
    private Node top;

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x);
        } else {
            int min = top.getMin() < x ? top.getMin() : x;
            Node node = new Node(x, min);
            node.setNext(top);
            top = node;
        }
    }

    public void pop() {
        if (top != null) {
            top = top.getNext();
        }
    }

    public int top() {
        return top.getValue();
    }

    public int getMin() {
        return top.getMin();
    }

    public class Node {
        int value, min;
        private Node next;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public int getValue() {
            return value;
        }

        public int getMin() {
            return min;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(30);
        s.push(20);
        s.push(10);
        s.push(40);
//        s.printStack();
        System.out.println("MINIMUM " + s.getMin());
        s.pop();
        System.out.println("MINIMUM " + s.getMin());
        s.pop();
        System.out.println("MINIMUM " + s.getMin());
//        s.printStack();

    }
}

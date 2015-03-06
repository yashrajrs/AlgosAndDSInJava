package practice.problemSolving.stackAndQueue;

import practice.dataStructures.Node;

/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should
 * all operate in O(1) time
 *
 * @author Yashraj R. Sontakke
 */
public class StackWithMin_3_2 {

    public NodeWithMin top;

    public void push(Integer data) {
        if (top == null) {
            top = new NodeWithMin(data, data);
        } else {
            Integer minimum = getTopMin() < data ? getTopMin() : data;
            NodeWithMin newNode = new NodeWithMin(data, minimum);
            newNode.setNext(top);
            top = newNode;
        }
    }

    public Integer pop() {
        if (top != null) {
            Integer temp = (Integer) top.getData();
            top = (NodeWithMin) top.getNext();
            return temp;
        }
        return null;
    }


    public Integer getTopMin() {
        return top.getMinimum();
    }


    public void printStack() {
        NodeWithMin n = top;
        System.out.println("Printing stack");
        while (n != null) {
            System.out.print(n.getData() + " ");
            n = (NodeWithMin) n.getNext();
        }
        System.out.println();
    }

    public class NodeWithMin extends Node {

        private final Integer minimum;

        public NodeWithMin(final Object data, final Integer minimum) {
            super(data);
            this.minimum = minimum;
        }

        public Integer getMinimum() {
            return minimum;
        }
    }

    public static void main(String[] args) {
        StackWithMin_3_2 s = new StackWithMin_3_2();
        s.push(30);
        s.push(20);
        s.push(10);
        s.push(40);
        s.printStack();
        System.out.println("MINIMUM " + s.getTopMin());
        s.pop();
        System.out.println("MINIMUM " + s.getTopMin());
        s.pop();
        System.out.println("MINIMUM " + s.getTopMin());
        s.printStack();

    }
}

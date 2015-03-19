package practice.dataStructures.queue;

import practice.dataStructures.Node;

import java.util.ArrayList;

/**
 * Implements a queue.
 *
 * @author Yashraj R. Sontakke
 */
public class Queue {
   public Node first, last;

    public void enqueue(Object data) {
        if (first == null) {
            last = new Node(data);
            first = last;
        } else {
            last.setNext(new Node(data));
            last = last.getNext();
        }
    }

    public Object dequeue() {
        if (first != null) {
            Object data = first.getData();
            first = first.getNext();
            return data;
        }
        return null;
    }

    public Object peek() {
        if (first==null){
            return null;
        }
        return first.getData();
    }

    public void printQueue() {
        ArrayList<Object> list = new ArrayList<Object>();
        Node n = first;
        while (n != null) {
            list.add(n.getData());
            n = n.getNext();
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.printQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.peek();
        queue.printQueue();
    }
}
